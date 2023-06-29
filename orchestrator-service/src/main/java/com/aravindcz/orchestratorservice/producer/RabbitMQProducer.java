package com.aravindcz.orchestratorservice.producer;

import com.aravindcz.orchestratorservice.dto.ListingDTO;
import com.aravindcz.orchestratorservice.model.Listing;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.directExchange}")
    private String exchange;

    @Value("${spring.rabbitmq.createQueue}")
    private String createQueue;

    @Value("${spring.rabbitmq.updateQueue}")
    private String updateQueue;

    @Value("${spring.rabbitmq.deleteQueue}")
    private String deleteQueue;



    public void createListing(ListingDTO listingDTO){

        rabbitTemplate.convertAndSend(exchange,createQueue,listingDTO);

    }


    public void updateListing(ListingDTO listingDTO){

        rabbitTemplate.convertAndSend(exchange,updateQueue,listingDTO);

    }


    public void deleteListing(String listingId){

        rabbitTemplate.convertAndSend(exchange,deleteQueue,listingId);

    }

}
