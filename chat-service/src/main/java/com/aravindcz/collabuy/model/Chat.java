package com.aravindcz.collabuy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketMessage;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class Chat implements Serializable {

    private long listingId;
    private long customerId;
    private String message;


}
