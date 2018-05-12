package com.ericardo.bnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericardo.bnb.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
