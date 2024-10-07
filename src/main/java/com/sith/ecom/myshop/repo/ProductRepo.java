package com.sith.ecom.myshop.repo;

import com.sith.ecom.myshop.entity.CustomerEntity;
import com.sith.ecom.myshop.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<ProductEntity, String> {
    @Query(value = "SELECT * FROM product WHERE description LIKE %?1% ORDER BY description DESC ",nativeQuery = true)
    public Page<ProductEntity> findAllWithSearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM product WHERE description LIKE %?1% ",nativeQuery = true)
    public Long countAllWithSearchText(String searchText);
}
