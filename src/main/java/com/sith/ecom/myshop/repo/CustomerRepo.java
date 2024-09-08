package com.sith.ecom.myshop.repo;

import com.sith.ecom.myshop.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {

}
