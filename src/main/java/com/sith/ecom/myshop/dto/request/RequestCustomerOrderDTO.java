package com.sith.ecom.myshop.dto.request;

import com.sith.ecom.myshop.entity.CustomerEntity;
import com.sith.ecom.myshop.entity.ProductEntity;
import com.sith.ecom.myshop.entity.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCustomerOrderDTO {


    private Date createdDate;
    private double totalCost;
    private int qty;
    private PaymentType paymentType;
    private String customer;
    private String product;



}
