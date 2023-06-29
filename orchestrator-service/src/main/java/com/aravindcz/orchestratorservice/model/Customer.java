package com.aravindcz.orchestratorservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable {


    private Long id;

    private String name;

}
