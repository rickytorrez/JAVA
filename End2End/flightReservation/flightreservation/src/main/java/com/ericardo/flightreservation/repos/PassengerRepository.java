package com.ericardo.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericardo.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
