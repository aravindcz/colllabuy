package com.aravindcz.listingservice.service;

import com.aravindcz.listingservice.dto.ListingDTO;
import com.aravindcz.listingservice.dto.ListingRabbitMQDTO;
import com.aravindcz.listingservice.model.Listing;
import com.aravindcz.listingservice.repository.ListingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    ObjectMapper objectMapper;


    public Listing createListing(ListingDTO listingDTO){

        Listing listing = convertListingDTOToListing(listingDTO);
        return listingRepository.save(listing);


    }

    public Listing readListing(String listingId){

        return listingRepository.findById(listingId).get();

    }

    public void updateListing(ListingRabbitMQDTO listingRabbitMQDTO){

        Listing listing = convertListingRabbitMQDTOToListing(listingRabbitMQDTO);
        listingRepository.save(listing);

    }


    public void deleteListing(String listingId){

        listingRepository.deleteById(listingId);

    }

    private Listing convertListingDTOToListing(ListingDTO listingDTO){

        Listing listing = objectMapper.convertValue(listingDTO,Listing.class);

        return listing;
    }


    private ListingDTO convertListingToListingDTO(Listing listing){

        ListingDTO listingDTO = objectMapper.convertValue(listing,ListingDTO.class);

        return listingDTO;
    }

    private Listing convertListingRabbitMQDTOToListing(ListingRabbitMQDTO listingRabbitMQDTO){
        Listing listing = objectMapper.convertValue(listingRabbitMQDTO,Listing.class);
        return listing;
    }
}
