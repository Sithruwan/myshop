package com.sith.ecom.myshop.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RequestCustomerDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean isActive;


}
