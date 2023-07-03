package com.aravindcz.orchestratorservice.client;

import com.aravindcz.orchestratorservice.dto.CustomerDTO;
import com.aravindcz.orchestratorservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "customer-service/customer")
public interface CustomerFeignClient {

    @PostMapping("")
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO);

    @GetMapping("/{customerId}")
    public Customer readCustomer(@PathVariable("customerId")Long customerId);

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable("customerId")Long customerId,@RequestBody CustomerDTO customerDTO);

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId")Long customerId);
}
