package com.aravindcz.orchestratorservice.service;


import com.aravindcz.orchestratorservice.dto.ListingDTO;
import com.aravindcz.orchestratorservice.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;

@Service
public class ListingService {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @Autowired
    private RestTemplate restTemplate;



    public void createListing(ListingDTO listingDTO){

        rabbitMQProducer.createListing(listingDTO);

    }

    public ListingDTO getListing(String listingId){

        return restTemplate.getForObject("http://localhost:8082/listing/"+listingId,ListingDTO.class);

    }

    public void updateListing(ListingDTO listingDTO){

        rabbitMQProducer.updateListing(listingDTO);

    }


    public void deleteListing(String listingId){

        rabbitMQProducer.deleteListing(listingId);

    }

}
