package com.sith.ecom.myshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "product")

public class ProductEntity {
    @Id
    @Column(name="property_id")
    private String propertyId;
    private Long qty;
    private Double unitPrice;
    private String description;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ProductImageEntity> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private HashSet<CustomerOrderEntity> orders = new HashSet<>();

}
