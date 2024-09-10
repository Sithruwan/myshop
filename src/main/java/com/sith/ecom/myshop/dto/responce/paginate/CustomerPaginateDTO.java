package com.sith.ecom.myshop.dto.responce.paginate;

import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerPaginateDTO {
    private long count;
    private List<ResponseCustomerDTO> dataList;
}
