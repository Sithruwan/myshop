package com.sith.ecom.myshop.service;

import com.sith.ecom.myshop.utill.CommonFileSaveBinaryDataDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public CommonFileSaveBinaryDataDto createResource(MultipartFile file, String directory, String bucket);
    public void deleteResource(String bucket,String directory, String fileName);
    public byte[] downloadFile(String bucket, String fileName);
}
