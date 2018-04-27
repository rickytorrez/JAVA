package com.ericardo.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericardo.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
