package com.ericardo.location.repos;

import org.springframework.data.repository.CrudRepository;

import com.ericardo.location.entities.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

}
