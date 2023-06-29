package com.aravindcz.orchestratorservice.controller;


import com.aravindcz.orchestratorservice.dto.CustomerDTO;
import com.aravindcz.orchestratorservice.model.Customer;
import com.aravindcz.orchestratorservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO){

        return customerService.createCustomer(customerDTO);

    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){

        return customerService.readCustomer(id);

    }

    @PutMapping("/")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO){

        customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/id")
    public void deleteCustomer(@PathVariable("id") Long id){

        customerService.deleteCustomer(id);

    }



}
