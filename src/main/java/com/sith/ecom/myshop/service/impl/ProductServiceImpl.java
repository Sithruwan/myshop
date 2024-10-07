package com.sith.ecom.myshop.service.impl;

import com.sith.ecom.myshop.dto.request.RequestProductDTO;
import com.sith.ecom.myshop.dto.responce.ResponseProductDTO;
import com.sith.ecom.myshop.dto.responce.ResponseProductImageDTO;
import com.sith.ecom.myshop.dto.responce.paginate.ProductPaginateDTO;
import com.sith.ecom.myshop.entity.ProductEntity;
import com.sith.ecom.myshop.entity.ProductImageEntity;
import com.sith.ecom.myshop.exception.EntryNotFoundException;
import com.sith.ecom.myshop.repo.ProductRepo;
import com.sith.ecom.myshop.service.ProductService;
import com.sith.ecom.myshop.utill.FileDataExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final FileDataExtractor fileDataExtractor;
    @Override
    public void createProduct(RequestProductDTO dto) {
        ProductEntity productEntity = ProductEntity.builder()
                .propertyId(UUID.randomUUID().toString())
                .description(dto.getDescription())
                .qty(dto.getQty())
                .unitPrice(dto.getUnitPrice())
                .build();

        productRepo.save(productEntity);
    }

    @Override
    public ResponseProductDTO getProductById(String id) {
        Optional<ProductEntity> selectedProduct = productRepo.findById(id);
        if(selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product not found...");
        }
        return createResponseProductDTO(selectedProduct.get());
    }

    @Override
    public void updateProduct(String id, RequestProductDTO dto) {
        Optional<ProductEntity> selectedProduct = productRepo.findById(id);
        if(selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product not found...");
        }
        ProductEntity productEntity = ProductEntity.builder()
                .propertyId(selectedProduct.get().getPropertyId())
                .description(dto.getDescription())
                .qty(dto.getQty())
                .unitPrice(dto.getUnitPrice())
                .build();
        productRepo.save(productEntity);
    }

    @Override
    public void deleteProduct(String id) {
        Optional<ProductEntity> selectedProduct = productRepo.findById(id);
        if(selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product not found...");
        }
        productRepo.deleteById(selectedProduct.get().getPropertyId());

    }

    @Override
    public ProductPaginateDTO getAllProduct(String searchText, int page, int pageSize) {
        return ProductPaginateDTO.builder()
                .count(productRepo.countAllWithSearchText(searchText))
                .dataList(productRepo.findAllWithSearchText(searchText, PageRequest.of(page, pageSize))
                        .stream().map(this::createResponseProductDTO).toList())
                .build();
    }


    private ResponseProductDTO createResponseProductDTO(ProductEntity entity){
        List<ResponseProductImageDTO> images = entity.getImages().stream().map(this::createResponseProductImageDTO).toList();
        return ResponseProductDTO.builder()
                .propertyId(entity.getPropertyId())
                .description(entity.getDescription())
                .qty(entity.getQty())
                .unitPrice(entity.getUnitPrice())
                .productImages(images)
                .build();
    }

    private ResponseProductImageDTO createResponseProductImageDTO(ProductImageEntity i){
        return ResponseProductImageDTO.builder()
                .propertyId(i.getPropertyId())
                .directory(fileDataExtractor.byteArrayToString(i.getDirectory()))
                .hash(fileDataExtractor.byteArrayToString(i.getHash()))
                .fileName(fileDataExtractor.byteArrayToString(i.getFileName()))
                .resourceUrl(fileDataExtractor.byteArrayToString(i.getResourceUrl()))
                .build();
    }

}
