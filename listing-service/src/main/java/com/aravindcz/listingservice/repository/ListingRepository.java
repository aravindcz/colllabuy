package com.aravindcz.listingservice.repository;

import com.aravindcz.listingservice.model.Listing;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface ListingRepository extends CouchbaseRepository<Listing,String> {



}
