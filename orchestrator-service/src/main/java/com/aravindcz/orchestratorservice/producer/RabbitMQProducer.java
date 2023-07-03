package com.aravindcz.orchestratorservice.producer;

import com.aravindcz.orchestratorservice.dto.ListingDTO;
import com.aravindcz.orchestratorservice.dto.ListingRabbitMQDTO;
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

    @Value("${spring.rabbitmq.updateQueue}")
    private String updateQueue;

    @Value("${spring.rabbitmq.deleteQueue}")
    private String deleteQueue;




    public void updateListing(ListingRabbitMQDTO listingRabbitMQDTO){

        rabbitTemplate.convertAndSend(exchange,updateQueue,listingRabbitMQDTO);

    }


    public void deleteListing(String listingId){

        rabbitTemplate.convertAndSend(exchange,deleteQueue,listingId);

    }

}
