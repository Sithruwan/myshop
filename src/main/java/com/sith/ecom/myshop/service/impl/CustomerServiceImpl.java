package com.sith.ecom.myshop.service.impl;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.entity.CustomerEntity;
import com.sith.ecom.myshop.repo.CustomerRepo;
import com.sith.ecom.myshop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    @Override
    public void createCustomer(RequestCustomerDTO dto) {
        CustomerEntity entity = CustomerEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .isActive(dto.isActive())
                .build();

        customerRepo.save(entity);
    }
}
