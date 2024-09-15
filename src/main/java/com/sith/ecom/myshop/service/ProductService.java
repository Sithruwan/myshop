package com.sith.ecom.myshop.service;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.dto.request.RequestProductDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseProductDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;
import com.sith.ecom.myshop.dto.responce.paginate.ProductPaginateDTO;

public interface ProductService {
    public void createProduct(RequestProductDTO dto);
    public ResponseProductDTO getProductById(String id);
    public void updateProduct(String id, RequestProductDTO dto);
    public void deleteProduct(String id);
    public ProductPaginateDTO getAllProduct(String searchText, int page, int pageSize);
//    public void updateCustomer(RequestCustomerDTO dto);
//    public void deleteCustomer(String id);
}
