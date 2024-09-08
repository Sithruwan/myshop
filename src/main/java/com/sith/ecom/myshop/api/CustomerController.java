package com.sith.ecom.myshop.api;

import com.sith.ecom.myshop.dto.request.RequestCustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")

public class CustomerController {

    @PostMapping()
    public RequestCustomerDTO createCustomer(@RequestBody RequestCustomerDTO dto) {
        System.out.println(dto.isActive());
        return dto;
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
