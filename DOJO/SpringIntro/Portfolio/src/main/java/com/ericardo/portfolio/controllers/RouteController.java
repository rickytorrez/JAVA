package com.ericardo.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {

	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
	
	@RequestMapping("/project")
	public String projects() {
		return "projects.html";
	}
	
	@RequestMapping("/me")
	public String aboutMe() {
		return "aboutme.html";
	}
}
