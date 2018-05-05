package com.ericardo.displaydate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayControllers {

	@RequestMapping("/")
	public String homeRoute( ) {
		return "index";
	}
	
	@RequestMapping("/date")
	public String dateRoute(Date date) {
		
		System.out.println(date);
		return "date";
	}
	
	@RequestMapping("/time")
	public String timeRoute() {
		return "time";
	}
	
}
