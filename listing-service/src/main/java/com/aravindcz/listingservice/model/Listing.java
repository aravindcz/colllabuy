package com.aravindcz.listingservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Listing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String listingId;
    @Field
    private String listingName;
    @Field
    private String listingDescription;
    @Field
    private String createdAt;
    @Field
    private String updatedAt;

}
