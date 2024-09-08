package com.sith.ecom.myshop.api;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
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
    public String getCustomerById(@PathVariable String id) {
        System.out.println(id);
        return null;
    }
    @GetMapping("/list")
    public String getAllCustomers(@RequestParam String searchText,@RequestParam int page,@RequestParam int pageSize) {
        System.out.println(searchText+" "+page+" "+pageSize);
        return null;
    }
    @PutMapping()
    public String updateCustomer(@RequestBody RequestCustomerDTO dto) {

        return null;
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable String id) {
        System.out.println(id);
        return null;
    }
}
