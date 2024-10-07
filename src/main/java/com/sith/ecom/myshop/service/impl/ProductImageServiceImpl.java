package com.sith.ecom.myshop.service.impl;

import com.sith.ecom.myshop.dto.request.RequestProductImageDTO;
import com.sith.ecom.myshop.dto.responce.ResponseProductImageDTO;
import com.sith.ecom.myshop.entity.ProductEntity;
import com.sith.ecom.myshop.entity.ProductImageEntity;
import com.sith.ecom.myshop.exception.EntryNotFoundException;
import com.sith.ecom.myshop.repo.ProductImageRepo;
import com.sith.ecom.myshop.repo.ProductRepo;
import com.sith.ecom.myshop.service.FileService;
import com.sith.ecom.myshop.service.ProductImageService;
import com.sith.ecom.myshop.utill.CommonFileSaveBinaryDataDto;
import com.sith.ecom.myshop.utill.FileDataExtractor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class ProductImageServiceImpl implements ProductImageService {

    @Value("${aws.bucket_name}")
    private String bucketName;
    private final ProductImageRepo productImageRepo;
    private final ProductRepo productRepo;
    private final FileService fileService;
    private final FileDataExtractor fileDataExtractor;
    @Override
    @SneakyThrows
    public void createProductImage(MultipartFile file, String productId)  {


        CommonFileSaveBinaryDataDto resource =null;
      try {
          Optional<ProductEntity> selectedProduct = productRepo.findById(productId);
          if (selectedProduct.isEmpty()) {
              throw new EntryNotFoundException("Product not found...!");
          }
           resource = fileService.createResource(file, "myShop/product-image/", bucketName);

          ProductImageEntity productImageEntity = ProductImageEntity.builder()
                  .propertyId(UUID.randomUUID().toString())
                  .hash(fileDataExtractor.blobToByteArray(resource.getHash()))
                  .directory(fileDataExtractor.blobToByteArray(resource.getDirectory()))
                  .fileName(fileDataExtractor.blobToByteArray(resource.getFileName()))
                  .resourceUrl(fileDataExtractor.blobToByteArray(resource.getResourceUrl()))
                  .product(selectedProduct.get())
                  .build();

          productImageRepo.save(productImageEntity);
      }catch (Exception e){
          fileService.deleteResource(bucketName, resource.getDirectory().toString(), fileDataExtractor.extractActualFileName(
                  new InputStreamReader(resource.getFileName().getBinaryStream()))
          );
      }

    }

    @Override
    public ResponseProductImageDTO getProductImageById(String id) {
        return null;
    }

    @Override
    public void deleteProductImage(String id) {

    }
}
