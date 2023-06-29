package com.aravindcz.listingservice.consumer;

import com.aravindcz.listingservice.configuration.RabbitMQHostConfiguration;
import com.aravindcz.listingservice.dto.ListingDTO;
import com.aravindcz.listingservice.model.Listing;
import com.aravindcz.listingservice.service.ListingService;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class RabbitMQConsumer {

    @Autowired
    private ListingService listingService;


    @RabbitListener(queues = "${spring.rabbitmq.createQueue}")
    public void listenToCreateQueue(ListingDTO listingDTO) {
        listingService.createListing(listingDTO);
    }

    @RabbitListener(queues = "${spring.rabbitmq.updateQueue}")
    public void listenToUpdateQueue(ListingDTO listingDTO) {
        listingService.updateListing(listingDTO);
    }

    @RabbitListener(queues = "${spring.rabbitmq.deleteQueue}")
    public void listenToDeleteQueue(String listingId) {
        listingService.deleteListing(listingId);
    }



}
