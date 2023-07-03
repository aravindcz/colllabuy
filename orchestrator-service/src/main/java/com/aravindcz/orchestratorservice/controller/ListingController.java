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
    public Listing createListing(@RequestBody ListingDTO listingDTO){

        return listingService.createListing(listingDTO);

    }


    @GetMapping("/{listingId}")
    public Listing getListing(@PathVariable("listingId") Long listingId){

        return listingService.readListing(listingId);

    }

    @PutMapping("/{listingId}")
    public String updateListing(@PathVariable("listingId") Long listingId, @RequestBody ListingDTO listingDTO){

        listingService.updateListing(listingId, listingDTO);
        return "Listing successfully updated";

    }

    @DeleteMapping("/{listingId}")
    public String deleteListing(@PathVariable("listingId") String listingId){

        listingService.deleteListing(listingId);
        return "Listing successfully deleted";

    }


}
