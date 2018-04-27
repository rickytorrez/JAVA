package com.ericardo.flightreservation.repos;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericardo.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	void findFlights(String from, String to, Date departureDate);

}
