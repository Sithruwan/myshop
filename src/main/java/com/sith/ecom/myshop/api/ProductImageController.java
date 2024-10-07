package com.sith.ecom.myshop.api;

import com.sith.ecom.myshop.dto.request.RequestProductImageDTO;
import com.sith.ecom.myshop.service.ProductImageService;
import com.sith.ecom.myshop.utill.StandardResponce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/productImage")
public class ProductImageController {
    private final ProductImageService productImageService;

    @PostMapping("/{product}")
    public ResponseEntity<StandardResponce> createProductImage(@RequestParam("productImage") MultipartFile file,
                                                               @PathVariable String product) {
        productImageService.createProductImage(file,product);
        return new ResponseEntity<>(new StandardResponce(201, "Product Image Created Successfully", null), HttpStatus.CREATED);
    }
}
