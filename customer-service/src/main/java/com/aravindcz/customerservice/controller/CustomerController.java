package com.aravindcz.customerservice.controller;

import com.aravindcz.customerservice.dto.CustomerDTO;
import com.aravindcz.customerservice.model.Customer;
import com.aravindcz.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping("")
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO){

        return customerService.createCustomer(customerDTO);

    }

    @GetMapping("/{customerId}")
    public Customer readCustomer(@PathVariable("customerId") Long customerId){

        return customerService.readCustomer(customerId);

    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long customerId,@RequestBody CustomerDTO customerDTO){

        customerService.updateCustomer(customerId,customerDTO);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){

        customerService.deleteCustomer(customerId);

    }



}
