package com.sith.ecom.myshop.service;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.dto.request.RequestCustomerOrderDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerOrderDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerOrderPaginateDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;

public interface CustomerOrderService {
    public void createCustomer(RequestCustomerOrderDTO dto);
    public ResponseCustomerOrderDTO getCustomerById(String id);
    public void updateCustomer(String id, RequestCustomerOrderDTO dto);
    public void deleteCustomer(String id);
    public CustomerOrderPaginateDTO getAllCustomers(String customerId, int page, int pageSize);

}
