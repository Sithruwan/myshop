package com.sith.ecom.myshop.service;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.dto.request.RequestCustomerOrderDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerOrderDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerOrderPaginateDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;

public interface CustomerOrderService {


    public void createCustomerOrder(RequestCustomerOrderDTO dto);
    public ResponseCustomerOrderDTO getCustomerOrderById(String id);
    public void updateCustomerOrder(String id, RequestCustomerOrderDTO dto);
    public void deleteCustomerOrder(String id);
    public CustomerOrderPaginateDTO getAllCustomerOrders(String customerId, int page, int pageSize);

}
