package com.sith.ecom.myshop.repo;

import com.sith.ecom.myshop.entity.CustomerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrderEntity, String> {
}
