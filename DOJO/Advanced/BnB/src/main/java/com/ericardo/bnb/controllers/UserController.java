package com.ericardo.bnb.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ericardo.bnb.models.User;
import com.ericardo.bnb.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService _uS;
	
	public UserController(UserService _uS) {
		this._uS = _uS;
	}
	
	// Route to Dashboard
	
	@RequestMapping("")
	public String dashboard(Model _model, HttpSession _session) {
		if(!_uS.isValid(_session)) 
			return _uS.redirect();														// Redirect is a method created on User Service
		_model.addAttribute("users", this._uS.all());
		return "dashboard";
	}
	
	// Logout on visiting login / registration
	
	@RequestMapping("/new")
	public String newUser(@ModelAttribute("user") User user, HttpSession _session) {
		_uS.logout(_session);
		return "newUser";
	}
	
	// Create a new user
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("user") User user, BindingResult _result, RedirectAttributes _flash, HttpSession _session) {
		if(_result.hasErrors()) {
			_flash.addFlashAttribute("errors", _result.getAllErrors());
			return "redirect:/users/new";
		}
		
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
