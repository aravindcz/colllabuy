package com.aravindcz.orchestratorservice.client;

import com.aravindcz.orchestratorservice.dto.CustomerDTO;
import com.aravindcz.orchestratorservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerClient {


    @Autowired
    private RestTemplate restTemplate;

    public Customer createCustomer(CustomerDTO customerDTO){

        return restTemplate.postForObject("http://localhost:8081/customer",customerDTO,Customer.class);

    }

    public Customer readCustomer(Long customerId){

        return restTemplate.getForObject("http://localhost:8081/customer/"+customerId,Customer.class);

    }

    public void updateCustomer(Long customerId, CustomerDTO customerDTO){

        restTemplate.put("http://localhost:8081/customer/"+customerId,customerDTO);

    }

    public void deleteCustomer(Long customerId){

        restTemplate.delete("http://localhost:8081/customer/"+customerId);

    }


}
