package com.sith.ecom.myshop.dto.responce;

import com.sith.ecom.myshop.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductImageDTO {
    private String propertyId;
    private String directory;
    private String fileName;
    private String resourceUrl;
    private String hash;



}
