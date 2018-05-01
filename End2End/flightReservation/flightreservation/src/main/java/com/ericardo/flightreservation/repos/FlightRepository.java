package com.ericardo.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ericardo.flightreservation.entities.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long> {
	
	@Query(value="select * FROM Flight where DEPARTURE_CITY  =  ?1 and ARRIVAL_CITY  =  ?2  and DATE_OF_DEPARTURE  =  ?3", nativeQuery=true)	
	List<Flight> findFlights(
			String from, 
			String to, 
			Date departureDate); 
}
