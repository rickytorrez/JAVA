package com.ericardo.flightreservation.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericardo.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository _fR;
	
	@RequestMapping("/findFlights")
	public String findFlights(
			@RequestParam("from") String from, 
			@RequestParam("to")String to, 
			@RequestParam("departureDate")@DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate) {
		_fR.findFlights(from,to,departureDate);
		return "/displayFlights";
	}

}
