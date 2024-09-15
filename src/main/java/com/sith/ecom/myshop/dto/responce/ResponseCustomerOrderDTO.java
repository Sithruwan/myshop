package com.sith.ecom.myshop.dto.responce;

import com.sith.ecom.myshop.entity.CustomerEntity;
import com.sith.ecom.myshop.entity.ProductEntity;
import com.sith.ecom.myshop.entity.enums.PaymentType;
import jakarta.persistence.*;

import java.util.Date;

public class ResponseCustomerOrderDTO {

    private String propertyId;


    private Date createdDate;


    private double totalCost;
    private int qty;


    private PaymentType paymentType;


    private String customer;


    private String product;
}
