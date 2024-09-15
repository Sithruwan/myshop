package com.sith.ecom.myshop.dto.responce.paginate;

import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerOrderDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerOrderPaginateDTO {
    private long count;
    private List<ResponseCustomerOrderDTO> dataList;
}
