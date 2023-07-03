package com.aravindcz.orchestratorservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Listing implements Serializable {


    private String id;

    private String name;

    private String description;




}
