package com.ericardo.ideas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.ideas.models.User;

@Controller
public class RouteController {
	
	
	/*************************************** HOME DASHBOARD **********************************/

	@RequestMapping("/*")
	public String index(@ModelAttribute("user") User user) {
		return "home";
	}
}