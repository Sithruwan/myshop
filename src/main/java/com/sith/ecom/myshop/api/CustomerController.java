package com.sith.ecom.myshop.api;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import com.sith.ecom.myshop.dto.responce.ResponseCustomerDTO;
import com.sith.ecom.myshop.dto.responce.paginate.CustomerPaginateDTO;
import com.sith.ecom.myshop.service.CustomerService;
import com.sith.ecom.myshop.utill.StandardResponce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<StandardResponce> createCustomer(@RequestBody RequestCustomerDTO dto) {
        customerService.createCustomer(dto);
        return new ResponseEntity<>(
                new StandardResponce(201,"Customer Created Successfully",dto),
                HttpStatus.CREATED
        );
    } 
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponce>  getCustomerById(@PathVariable String id) {
        ResponseCustomerDTO customerById = customerService.getCustomerById(id);
        return new ResponseEntity<>(
                new StandardResponce(200,"Customer Found ",customerById),
                HttpStatus.OK
        );
    }
    @GetMapping("/list")
    public ResponseEntity<StandardResponce> getAllCustomers(@RequestParam String searchText,@RequestParam int page,@RequestParam int pageSize) {
        CustomerPaginateDTO allCustomers = customerService.getAllCustomers(searchText, page, pageSize);
        return new ResponseEntity<>(
                new StandardResponce(200,"Customer Found ",allCustomers),
                HttpStatus.OK
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponce> updateCustomer(@PathVariable String id,@RequestBody RequestCustomerDTO dto) {
        customerService.updateCustomer(id,dto);
        return new ResponseEntity<>(
                new StandardResponce(201,"Customer Updated ",null),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponce> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponce(200,"Customer Deleted ",null),
                HttpStatus.OK
        );
    }
}
