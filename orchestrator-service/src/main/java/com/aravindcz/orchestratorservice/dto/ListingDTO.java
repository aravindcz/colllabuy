package com.aravindcz.orchestratorservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ListingDTO implements Serializable {

    private String name;

    private String description;

}
