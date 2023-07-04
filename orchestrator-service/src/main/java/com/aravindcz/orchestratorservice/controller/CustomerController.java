package com.aravindcz.orchestratorservice.controller;


import com.aravindcz.orchestratorservice.dto.CustomerDTO;
import com.aravindcz.orchestratorservice.model.Customer;
import com.aravindcz.orchestratorservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Value("${eureka.instance.metadataMap.zone}")
    private String zone;

    @Autowired
    private CustomerService customerService;

    @PostMapping("")
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO){

        System.out.println(zone);
        return customerService.createCustomer(customerDTO);

    }

    @GetMapping("/{customerId}")
    public Customer readCustomer(@PathVariable("customerId") Long customerId){

        return customerService.readCustomer(customerId);

    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long customerId, @RequestBody CustomerDTO customerDTO){

        customerService.updateCustomer(customerId, customerDTO);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){

        customerService.deleteCustomer(customerId);

    }



}
