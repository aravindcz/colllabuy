package com.aravindcz.collabuy.model;

import org.springframework.web.socket.WebSocketMessage;

import java.io.Serializable;

public class SocketMessage implements Serializable, WebSocketMessage {

    private long listingId;
    private long customerId;
    private String message;

    public SocketMessage(Chat chat){
        this.listingId = chat.getListingId();
        this.customerId = chat.getCustomerId();
        this.message = chat.getMessage();
    }


    @Override
    public Object getPayload() {
        return "{"+"listingId: "+this.listingId+","+
                "customerId: "+this.customerId+","+
                "message: "+this.message+
                "}";
    }

    @Override
    public int getPayloadLength() {
        return 0;
    }

    @Override
    public boolean isLast() {
        return false;
    }

}
