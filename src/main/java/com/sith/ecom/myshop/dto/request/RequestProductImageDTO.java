package com.sith.ecom.myshop.dto.request;
import com.sith.ecom.myshop.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductImageDTO {
  private MultipartFile image;
}
