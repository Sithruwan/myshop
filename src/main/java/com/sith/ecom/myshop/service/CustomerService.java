package com.sith.ecom.myshop.service;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;

public interface CustomerService {
    public void createCustomer(RequestCustomerDTO dto);
    public ResponseCustomerDTO getCustomerById(String id);
    public void updateCustomer(String id, RequestCustomerDTO dto);
    public void deleteCustomer(String id);
    public CustomerPaginateDTO getAllCustomers(String searchText, int page, int pageSize);
//    public void updateCustomer(RequestCustomerDTO dto);
//    public void deleteCustomer(String id);
}
