package com.sith.ecom.myshop.service;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.dto.request.RequestProductImageDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseProductImageDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ProductImageService {
    public void createProductImage(MultipartFile file, String productId);
    public ResponseProductImageDTO getProductImageById(String id);
//    public void updateProductImage(String id, RequestProductImageDTO dto);
    public void deleteProductImage(String id);
//    public ResponseProductImageDTO getAllProductImage(String searchText, int page, int pageSize);
//    public void updateCustomer(RequestCustomerDTO dto);
//    public void deleteCustomer(String id);
}
