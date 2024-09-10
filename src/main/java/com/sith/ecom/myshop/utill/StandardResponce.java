package com.sith.ecom.myshop.utill;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardResponce {
    private int status;
    private String message;
    private Object data;
}
