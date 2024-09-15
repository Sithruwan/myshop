package com.sith.ecom.myshop.dto.responce.paginate;

import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseProductDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductPaginateDTO {
    private long count;
    private List<ResponseProductDTO> dataList;
}
