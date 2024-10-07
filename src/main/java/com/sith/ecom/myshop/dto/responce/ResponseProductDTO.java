package com.sith.ecom.myshop.dto.responce;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductDTO {

    private String propertyId;
    private Long qty;
    private Double unitPrice;
    private String description;

    private List<ResponseProductImageDTO> productImages ;



}
