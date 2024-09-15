package com.sith.ecom.myshop.dto.responce;

import com.sith.ecom.myshop.entity.CustomerOrderEntity;
import java.util.HashSet;
import java.util.List;

public class ResponseProductDTO {

    private String propertyId;
    private Long qty;
    private Double unitPrice;
    private String description;

    private List<ResponceProductImageDTO> productImages ;



}
