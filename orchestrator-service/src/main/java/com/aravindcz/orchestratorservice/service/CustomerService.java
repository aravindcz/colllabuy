package com.aravindcz.orchestratorservice.service;


import com.aravindcz.orchestratorservice.client.CustomerClient;
import com.aravindcz.orchestratorservice.dto.CustomerDTO;
import com.aravindcz.orchestratorservice.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerClient customerClient;


    public Customer createCustomer(CustomerDTO customerDTO){

        return customerClient.createCustomer(customerDTO);

    }

    public Customer readCustomer(Long customerId){

        return customerClient.readCustomer(customerId);

    }

    public void updateCustomer(Long customerId, CustomerDTO customerDTO){

        customerClient.updateCustomer(customerId, customerDTO);

    }

    public void deleteCustomer(Long customerId){

        customerClient.deleteCustomer(customerId);

    }


}
