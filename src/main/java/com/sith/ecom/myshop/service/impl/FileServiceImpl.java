package com.sith.ecom.myshop.service.impl;

import com.sith.ecom.myshop.service.FileService;
import com.sith.ecom.myshop.utill.CommonFileSaveBinaryDataDto;
import com.sith.ecom.myshop.utill.ImageUploadGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final AmazonS3 s3;
    private final AmazonS3Client s3Client;
    private final ImageUploadGenerator imageUploadGenerator;


    @Override
    public CommonFileSaveBinaryDataDto createResource(MultipartFile file, String directory,
                                                      String bucket) {
        try {
            String originalFilename = file.getOriginalFilename();
            String newFileName = imageUploadGenerator.generateDevelopersStackResourceName
                    (originalFilename, UUID.randomUUID().toString());
            PutObjectResult putObjectResult = s3Client.putObject(new
                    PutObjectRequest(bucket, directory + "" + newFileName, file.getInputStream(),
                    new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));

            return new CommonFileSaveBinaryDataDto(
                    new SerialBlob(putObjectResult.getContentMd5().getBytes()),
                    new SerialBlob(directory.getBytes()),
                    new SerialBlob(newFileName.getBytes()),
                    new SerialBlob(s3Client.getResourceUrl(bucket, directory + newFileName).getBytes()));
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteResource(String bucket, String directory, String fileName) {
        s3Client.deleteObject(bucket, directory + fileName);
    }

    @Override
    public byte[] downloadFile(String bucket, String fileName) {
        S3Object object = s3.getObject(bucket, fileName);
        S3ObjectInputStream objectContent = object.getObjectContent();
        try {
            return IOUtils.toByteArray(objectContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*public File convertMultipartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fileOutputStream =  new FileOutputStream(convFile);
       *//* fileOutputStream.write(file.getBytes());
        fileOutputStream.close();*//*
        return convFile;
    }*/
}
