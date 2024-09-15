package com.sith.ecom.myshop.entity;

import com.sith.ecom.myshop.entity.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "customer_order")
public class CustomerOrderEntity {
    @Id
    @Column(name = "property_id",nullable = false,length = 80)
    private String propertyId;

    @Column(name = "created_date",nullable = false,columnDefinition = "DATETIME")
    private Date createdDate;

    @Column(name = "total_cost",nullable = false,columnDefinition = "DOUBLE")
    private double totalCost;
    private int qty;
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id",
            referencedColumnName = "property_id")
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "property_id")
    private ProductEntity product;



}
