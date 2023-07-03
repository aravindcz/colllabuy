package com.aravindcz.listingservice.consumer;

import com.aravindcz.listingservice.dto.ListingDTO;
import com.aravindcz.listingservice.dto.ListingRabbitMQDTO;
import com.aravindcz.listingservice.service.ListingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConsumer {

    @Autowired
    private ListingService listingService;


    @RabbitListener(queues = "${spring.rabbitmq.updateQueue}")
    public void listenToUpdateQueue(ListingRabbitMQDTO listingRabbitMQDTO) {
        listingService.updateListing(listingRabbitMQDTO);
    }

    @RabbitListener(queues = "${spring.rabbitmq.deleteQueue}")
    public void listenToDeleteQueue(String listingId) {
        listingService.deleteListing(listingId);
    }



}
