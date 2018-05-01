package com.ericardo.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericardo.flightreservation.entities.Flight;
import com.ericardo.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository _fR;
	
	@RequestMapping("/findFlights")
	public String findFlights(
			@RequestParam("from") String from,
			@RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, ModelMap _mM) {
		System.out.println(from);
		System.out.println(to);
		System.out.println(departureDate);
		
		List<Flight> flights = _fR.findFlights(from,to,departureDate);
		
		
		System.out.println(flights);
		_mM.addAttribute("flights", flights);
		return "displayFlights";
	}
}
