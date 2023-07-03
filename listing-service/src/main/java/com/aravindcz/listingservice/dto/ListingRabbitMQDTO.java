package com.aravindcz.listingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ListingRabbitMQDTO implements Serializable {

    private String id;
    private String name;
    private String description;

}
