package com.ericardo.bnb.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.bnb.models.User;
import com.ericardo.bnb.services.UserService;

@Controller
@RequestMapping("/**")																		// Wildcard all routes
public class RouteController {
	
	private UserService _uS;
	
	public RouteController(UserService _uS) {
		this._uS = _uS;
	}
	
	@RequestMapping("")																		// If route doesn't exist, redirect to login if not in session, else dashboard
	public String index(HttpServletRequest _request, HttpSession _session) {
		if(!_uS.isValid(_session)) {															// If user not in session, take him to home route
			return "redirect:/users/new";
		} else {
			User user = _uS.find((long) _session.getAttribute("id"));						// Query for user id
			return "dashboard";	
		}
	}
	
}
