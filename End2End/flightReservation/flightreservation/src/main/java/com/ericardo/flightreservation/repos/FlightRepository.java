package com.ericardo.flightreservation.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ericardo.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	// Value
	@Query(value="from Flight where departureCity=:departureCity and arrivalCity-:arrivalCity and dateOfDeparture=:dateOfDeparture", nativeQuery=true)
	List<Flight> findFlights(
			@Param("departureCity") String from, 
			@Param("arrivalCity")String to, 
			@Param("dateOfDeparture")Date departureDate); 
}
