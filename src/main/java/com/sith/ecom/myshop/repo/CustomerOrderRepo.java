package com.sith.ecom.myshop.repo;

import com.sith.ecom.myshop.entity.CustomerEntity;
import com.sith.ecom.myshop.entity.CustomerOrderEntity;
import com.sith.ecom.myshop.service.CustomerOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrderEntity, String> {
    @Query(value = "SELECT * FROM customer_order WHERE customer_id = ?1",nativeQuery = true)
    public Page<CustomerOrderEntity> findAllWithSearchText(String customerId, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM customer_order WHERE customer_id = ?1",nativeQuery = true)
    public Long countAllWithSearchText(String customerId);

}
