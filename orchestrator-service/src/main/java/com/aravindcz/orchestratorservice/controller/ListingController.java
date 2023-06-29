package com.aravindcz.orchestratorservice.controller;


import com.aravindcz.orchestratorservice.dto.ListingDTO;
import com.aravindcz.orchestratorservice.model.Listing;
import com.aravindcz.orchestratorservice.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listing")
public class ListingController {


    @Autowired
    private ListingService listingService;


    @PostMapping("")
    public String createListing(@RequestBody ListingDTO listingDTO){

        listingService.createListing(listingDTO);
        return "Listing successfully created";

    }


    @GetMapping("/{listingId}")
    public ListingDTO getListing(@PathVariable String listingId){

        return listingService.getListing(listingId);

    }

    @PutMapping("")
    public String updateListing(@RequestBody ListingDTO listingDTO){

        listingService.updateListing(listingDTO);
        return "Listing successfully updated";

    }

    @DeleteMapping("/{lisitngId}")
    public String deleteListing(@PathVariable String listingId){

        listingService.deleteListing(listingId);
        return "Listing successfully deleted";

    }


}
