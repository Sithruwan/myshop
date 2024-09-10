package com.sith.ecom.myshop.dto.responce;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCustomerDTO {

    private String propertyId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean isActive;
}
