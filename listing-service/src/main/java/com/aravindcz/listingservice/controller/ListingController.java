package com.aravindcz.listingservice.controller;

import com.aravindcz.listingservice.dto.ListingDTO;
import com.aravindcz.listingservice.model.Listing;
import com.aravindcz.listingservice.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listing")
public class ListingController {


    @Autowired
    private ListingService listingService;

    @PostMapping("")
    public Listing createListing(@RequestBody ListingDTO listingDTO){
        return listingService.createListing(listingDTO);
    }

    @GetMapping("/{listingId}")
    public Listing readListing(@PathVariable("listingId") String listingId){

        return listingService.readListing(listingId);

    }


}
