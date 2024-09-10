package com.sith.ecom.myshop.service.impl;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;
import com.sith.ecom.myshop.entity.CustomerEntity;
import com.sith.ecom.myshop.exception.EntryNotFoundException;
import com.sith.ecom.myshop.repo.CustomerRepo;
import com.sith.ecom.myshop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    @Override
    public void createCustomer(RequestCustomerDTO dto) {
        CustomerEntity entity = CustomerEntity.builder()
                .propertyId(UUID.randomUUID().toString())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .isActive(dto.isActive())
                .build();

        customerRepo.save(entity);
    }

    @Override
    public ResponseCustomerDTO getCustomerById(String id) {
        Optional<CustomerEntity> byId = customerRepo.findById(id);

        if (byId.isPresent()) {
            return toResponseCustomerDTO(byId.get());
        }
        else {
            throw new EntryNotFoundException("Customer not found");
        }

}

    @Override
    public void updateCustomer(String id, RequestCustomerDTO dto) {
        Optional<CustomerEntity> byId = customerRepo.findById(id);

        if(byId.isPresent()){
            CustomerEntity customerEntity = byId.get();

            customerEntity.setName(dto.getName());
            customerEntity.setEmail(dto.getEmail());
            customerEntity.setPhone(dto.getPhone());
            customerEntity.setAddress(dto.getAddress());
            customerEntity.setActive(dto.isActive());
            customerRepo.save(customerEntity);
        }else {
            throw new EntryNotFoundException("Customer not found");
        }
    }

    @Override
    public void deleteCustomer(String id) {

        Optional<CustomerEntity> byId = customerRepo.findById(id);

        if(byId.isPresent()){
            customerRepo.delete(byId.get());
        }else {
            throw new EntryNotFoundException("Customer not found");
        }
    }

    @Override
    public CustomerPaginateDTO getAllCustomers(String searchText, int page, int pageSize) {
        return CustomerPaginateDTO.builder()
                .dataList(customerRepo.findAllWithSearchText(searchText, PageRequest.of(page, pageSize))
                        .stream().map(this::toResponseCustomerDTO).toList())
                .count(customerRepo.countAllWithSearchText(searchText))
                .build();
    }


    public ResponseCustomerDTO toResponseCustomerDTO(CustomerEntity entity) {

                return ResponseCustomerDTO.builder()
                        .propertyId(entity.getPropertyId())
                        .name(entity.getName())
                        .email(entity.getEmail())
                        .phone(entity.getPhone())
                        .address(entity.getAddress())
                        .isActive(entity.isActive())
                        .build();

    }

}
