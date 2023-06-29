package com.aravindcz.listingservice.controller;

import com.aravindcz.listingservice.dto.ListingDTO;
import com.aravindcz.listingservice.model.Listing;
import com.aravindcz.listingservice.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listing")
public class ListingController {


    @Autowired
    private ListingService listingService;

    @GetMapping("/{listingId}")
    public ListingDTO getListing(@PathVariable String listingId){

        return listingService.getListing(listingId);

    }


}
