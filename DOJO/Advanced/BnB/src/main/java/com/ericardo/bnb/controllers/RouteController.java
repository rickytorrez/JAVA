package com.ericardo.bnb.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		if(!_uS.isValid(_session)) {
			return "redirect:/users/new";
		} else {
			return "redirect:/users";
		}
	}
	
}
