package com.sith.ecom.myshop.api;

import com.sith.ecom.myshop.dto.request.RequestProductImageDTO;
import com.sith.ecom.myshop.service.ProductImageService;
import com.sith.ecom.myshop.utill.StandardResponce;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/product-images")
public class ProductImageController {
    private final ProductImageService productImageService;

    @PostMapping("/{product}")
    public ResponseEntity<StandardResponce> 
    createProductImage(@RequestPart(value = "productImageFile") MultipartFile productImageFile,
                                                               @PathVariable String product) throws SQLException, IOException{
                                                                System.out.println("file: "+productImageFile);
        productImageService.createProductImage(productImageFile,product);
        return new ResponseEntity<>(new StandardResponce(201, "Product Image Created Successfully", null), HttpStatus.CREATED);
    }




}
