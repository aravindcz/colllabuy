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

        Customer customer = customerClient.createCustomer(customerDTO);
        return customer;
    }

    public Customer readCustomer(Long id){

        return customerClient.getCustomer(id);

    }

    public void updateCustomer(CustomerDTO customerDTO){

        customerClient.updateCustomer(customerDTO);

    }

    public void deleteCustomer(Long id){

        customerClient.deleteCustomer(id);

    }


}
