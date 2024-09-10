package com.sith.ecom.myshop.repo;

import com.sith.ecom.myshop.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {

    @Query(value = "SELECT * FROM customer WHERE name LIKE %?1% OR email LIKE %?1% OR phone LIKE %?1% OR address LIKE %?1% ORDER BY name DESC",nativeQuery = true)
    public Page<CustomerEntity> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM customer WHERE name LIKE %?1% OR email LIKE %?1% OR phone LIKE %?1% OR address LIKE %?1%",nativeQuery = true)
    public Long countAllWithSearchText(String searchText);
}
