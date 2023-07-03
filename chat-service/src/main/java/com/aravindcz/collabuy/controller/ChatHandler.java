package com.aravindcz.collabuy.controller;

import com.aravindcz.collabuy.model.Chat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class ChatHandler extends TextWebSocketHandler {

    private Map<Long, List<WebSocketSession>> productIdToActiveWebsocketSessionsMap = new HashMap<>();

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private KafkaAdmin kafkaAdmin;


    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        Chat chat = objectMapper.readValue(message.getPayload(),Chat.class);


        addWebsocketSessionIfNotPresent(session,chat);
        createKafkaTopicIfNotPresent(chat);

        sendMessageToAllOtherMembers(chat,message);


    }


    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        removeWebsocketSessionFromMap(session);

    }

    private void addWebsocketSessionIfNotPresent(WebSocketSession session,Chat chat){

        long listingId = chat.getListingId();
        if(!productIdToActiveWebsocketSessionsMap.containsKey(listingId))
            productIdToActiveWebsocketSessionsMap.put(listingId,new ArrayList<>());

        List<WebSocketSession> webSocketSessionList = productIdToActiveWebsocketSessionsMap.get(chat.getListingId());

        if(!webSocketSessionList.contains(session))
            webSocketSessionList.add(session);

    }

    private void createKafkaTopicIfNotPresent(Chat chat){


        long listingId = chat.getListingId();
        boolean isPresent = false;


        try (AdminClient adminClient = AdminClient.create(kafkaAdmin.getConfigurationProperties())) {
            ListTopicsOptions options = new ListTopicsOptions();
            options.listInternal(true);  // Include internal topics if needed

            ListTopicsResult topicsResult = adminClient.listTopics(options);
            Collection<TopicListing> topicListings = topicsResult.listings().get();

            for (TopicListing topicListing : topicListings) {
                if(topicListing.name().equals(String.valueOf(listingId)))
                    isPresent = true;
            }

            if(!isPresent){
                NewTopic newTopic = new NewTopic(String.valueOf(listingId), 1,(short)0);
                adminClient.createTopics(Collections.singleton(newTopic));
            }



        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }



    }


    @KafkaListener(topics = "chat",groupId = "chat")
    public void listenChats(Chat chat) throws IOException {

        long listingId = chat.getListingId();

        String jsonChat = objectMapper.writeValueAsString(chat);
        TextMessage textMessage = new TextMessage(jsonChat);

        List<WebSocketSession> webSocketSessionList = productIdToActiveWebsocketSessionsMap.get(listingId);

        for(WebSocketSession session : webSocketSessionList)
            session.sendMessage(textMessage);

    }

    private void sendMessageToAllOtherMembers(Chat chat,TextMessage message) throws IOException {


        kafkaTemplate.send("chat",chat);


    }



    private void removeWebsocketSessionFromMap(WebSocketSession session){

        for(long productId : productIdToActiveWebsocketSessionsMap.keySet()){
            for(WebSocketSession savedSession : productIdToActiveWebsocketSessionsMap.get(productId)){
                if(savedSession == session)
                    productIdToActiveWebsocketSessionsMap.get(productId).remove(session);
            }
        }

    }





}
