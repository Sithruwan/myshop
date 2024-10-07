package com.sith.ecom.myshop.service.impl;

import com.sith.ecom.myshop.dto.request.RequestCustomerOrderDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerOrderDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerOrderPaginateDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;
import com.sith.ecom.myshop.entity.CustomerEntity;
import com.sith.ecom.myshop.entity.CustomerOrderEntity;
import com.sith.ecom.myshop.entity.ProductEntity;
import com.sith.ecom.myshop.exception.EntryNotFoundException;
import com.sith.ecom.myshop.repo.CustomerOrderRepo;
import com.sith.ecom.myshop.repo.CustomerRepo;
import com.sith.ecom.myshop.repo.ProductRepo;
import com.sith.ecom.myshop.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepo customerOrderRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;

    @Override
    public void createCustomerOrder(RequestCustomerOrderDTO dto) {
        Optional<CustomerEntity> selectedCustomer = customerRepo.findById(dto.getCustomer());
        Optional<ProductEntity> selectedProduct = productRepo.findById(dto.getProduct());

        if(selectedCustomer.isEmpty() || selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Customer or Product not found");
        }

        CustomerOrderEntity customerOrderEntity = CustomerOrderEntity.builder()
                .propertyId(UUID.randomUUID().toString())
                .customer(selectedCustomer.get())
                .createdDate(dto.getCreatedDate())
                .totalCost(dto.getTotalCost())
                .qty(dto.getQty())
                .paymentType(dto.getPaymentType())
                .product(selectedProduct.get())
                .build();

        customerOrderRepo.save(customerOrderEntity);
    }

    @Override
    public ResponseCustomerOrderDTO getCustomerOrderById(String id) {
        Optional<CustomerOrderEntity> byId = customerOrderRepo.findById(id);

        if(byId.isEmpty()){
            throw new EntryNotFoundException("Customer Order not found");
        }
        return createResponseCustomerOrderDTO(byId.get());
    }

    @Override
    public void updateCustomerOrder(String id, RequestCustomerOrderDTO dto) {

    }

    @Override
    public void deleteCustomerOrder(String id) {
        customerOrderRepo.deleteById(id);
    }

    @Override
    public CustomerOrderPaginateDTO getAllCustomerOrders(String customerId, int page, int pageSize) {
        return CustomerOrderPaginateDTO.builder()
                .dataList(customerOrderRepo.findAllWithSearchText(customerId, PageRequest.of(page, pageSize))
                        .stream().map(this::createResponseCustomerOrderDTO).toList())
                .count(customerOrderRepo.countAllWithSearchText(customerId))
                .build();
    }

    private ResponseCustomerOrderDTO createResponseCustomerOrderDTO(CustomerOrderEntity entity) {
        return ResponseCustomerOrderDTO.builder()
                .propertyId(entity.getPropertyId())
                .createdDate(entity.getCreatedDate())
                .totalCost(entity.getTotalCost())
                .qty(entity.getQty())
                .paymentType(entity.getPaymentType())
                .build();
    }
}
