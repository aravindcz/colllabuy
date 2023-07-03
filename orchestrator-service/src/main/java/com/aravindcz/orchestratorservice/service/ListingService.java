package com.aravindcz.orchestratorservice.service;


import com.aravindcz.orchestratorservice.dto.ListingDTO;
import com.aravindcz.orchestratorservice.dto.ListingRabbitMQDTO;
import com.aravindcz.orchestratorservice.model.Listing;
import com.aravindcz.orchestratorservice.producer.RabbitMQProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private ObjectMapper objectMapper;


    public Listing createListing(ListingDTO listingDTO){

        return restTemplate.postForObject("http://listing-service/listing",listingDTO,Listing.class);

    }

    public Listing readListing(String listingId){

        return restTemplate.getForObject("http://listing-service/listing/"+listingId,Listing.class);

    }

    public void updateListing(String listingId, ListingDTO listingDTO){

        ListingRabbitMQDTO listingRabbitMQDTO = convertListingIdAndDTOToListingRabbitMQDTO(listingId,listingDTO);
        rabbitMQProducer.updateListing(listingRabbitMQDTO);

    }


    public void deleteListing(String listingId){

        rabbitMQProducer.deleteListing(listingId);

    }


    private ListingRabbitMQDTO convertListingIdAndDTOToListingRabbitMQDTO(String listingId, ListingDTO listingDTO){
        ListingRabbitMQDTO listingRabbitMQDTO = objectMapper.convertValue(listingDTO,ListingRabbitMQDTO.class);
        listingRabbitMQDTO.setId(listingId);
        return listingRabbitMQDTO;
    }

}
