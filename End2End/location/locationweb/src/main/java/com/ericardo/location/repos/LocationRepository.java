package com.ericardo.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericardo.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
