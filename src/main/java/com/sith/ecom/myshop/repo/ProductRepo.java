package com.sith.ecom.myshop.repo;

import com.sith.ecom.myshop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, String> {
}
