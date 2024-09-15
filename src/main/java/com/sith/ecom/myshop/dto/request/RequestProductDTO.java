package com.sith.ecom.myshop.dto.request;

import com.sith.ecom.myshop.entity.CustomerOrderEntity;
import com.sith.ecom.myshop.entity.ProductImageEntity;
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

public class RequestProductDTO {


    private Long qty;
    private Double unitPrice;
    private String description;



}
