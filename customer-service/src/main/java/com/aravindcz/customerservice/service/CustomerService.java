package com.aravindcz.customerservice.service;

import com.aravindcz.customerservice.dto.CustomerDTO;
import com.aravindcz.customerservice.model.Customer;
import com.aravindcz.customerservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Customer createCustomer(CustomerDTO customerDTO){

        Customer customer = convertCustomerDTOToCustomer(customerDTO);
        customerRepository.save(customer);
        return customer;
    }

    public Customer readCustomer(Long id){

        return customerRepository.findById(id).get();

    }

    public void updateCustomer(Long customerId,CustomerDTO customerDTO){

        Customer customer = convertCustomerDTOToCustomer(customerDTO);
        customer.setId(customerId);
        customerRepository.save(customer);

    }

    public void deleteCustomer(Long customerId){

        customerRepository.deleteById(customerId);

    }

    private Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){

        Customer customer = objectMapper.convertValue(customerDTO,Customer.class);
        return customer;

    }

}
