package com.ericardo.bnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericardo.bnb.models.Listing;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long> {

}
