package com.sith.ecom.myshop.api;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.dto.request.RequestProductDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseProductDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;
import com.sith.ecom.myshop.dto.responce.paginate.ProductPaginateDTO;
import com.sith.ecom.myshop.service.ProductService;
import com.sith.ecom.myshop.utill.StandardResponce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<StandardResponce> createProduct(@RequestBody RequestProductDTO dto) {
        productService.createProduct(dto);
        return new ResponseEntity<>(
                new StandardResponce(201,"Customer Created Successfully",dto),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponce>  getProductById(@PathVariable String id) {
        ResponseProductDTO productById = productService.getProductById(id);
        return new ResponseEntity<>(
                new StandardResponce(200,"Product Found ",productById),
                HttpStatus.OK
        );
    }
    @GetMapping("/list")
    public ResponseEntity<StandardResponce> getAllProducts(@RequestParam String searchText,@RequestParam int page,@RequestParam int pageSize) {
        ProductPaginateDTO allCustomers = productService.getAllProduct(searchText, page, pageSize);
        return new ResponseEntity<>(
                new StandardResponce(200,"Product Found ",allCustomers),
                HttpStatus.OK
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponce> updateProduct(@PathVariable String id,@RequestBody RequestProductDTO dto) {
        productService.updateProduct(id,dto);
        return new ResponseEntity<>(
                new StandardResponce(201,"Product Updated ",null),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponce> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(
                new StandardResponce(204,"product Deleted ",null),
                HttpStatus.NO_CONTENT
        );
    }

}
