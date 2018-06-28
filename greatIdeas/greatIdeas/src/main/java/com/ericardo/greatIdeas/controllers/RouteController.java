package com.ericardo.greatIdeas.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.greatIdeas.models.User;
import com.ericardo.greatIdeas.services.UserService;

@Controller
public class RouteController {
	
	@Autowired
	private UserService _uS;
	
	/*************************************** HOME DASHBOARD **********************************/

	@RequestMapping("/*")
	public String index(HttpServletRequest _request, HttpSession _session, Model _model, @ModelAttribute("user") User user) {
		if(!_uS.isValid(_session)) {
			System.out.println("hola!");
			return "index";
		} else {
			User _user = _uS.find((Long) _session.getAttribute("id"));
			_model.addAttribute("user", _user);
			return "redirect:/ideas";
		}
	}
}
