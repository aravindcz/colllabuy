package com.aravindcz.listingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ListingDTO implements Serializable {

    private String listingName;
    private String listingDescription;

}
