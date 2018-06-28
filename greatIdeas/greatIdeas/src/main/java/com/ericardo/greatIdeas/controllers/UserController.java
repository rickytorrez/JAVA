package com.ericardo.greatIdeas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ericardo.greatIdeas.models.User;
import com.ericardo.greatIdeas.services.UserService;

@Controller
@RequestMapping("/ideas")
public class UserController {
	
	@Autowired
	private UserService _uS;
	
	/*************************************** IDEAS LANDING ***********************************/
	@RequestMapping("/")
	public String landingPage(HttpSession _session, Model _model) {
		if(!_uS.isValid(_session)) 
			return "redirect:/";
		
		User user = _uS.find( (Long) _session.getAttribute("id"));
		_model.addAttribute("user", user);
		return "dashboard";
	}
	
	
	/*************************************** POST NEW USER ***********************************/
	
	@PostMapping("/newUser")
	public String create(@Valid @ModelAttribute("user") User user, BindingResult _result, RedirectAttributes _flash, HttpSession _session) {
		if(_result.hasErrors()) {
			_flash.addFlashAttribute("errors", _result.getAllErrors());
			return "redirect:/";
		} else {
			User exists = _uS.findByEmail(user.getEmail());		
			
			if(exists == null) {
				User _user = _uS.create(user);
				_uS.login(_session, _user.getId());
				return "redirect:/ideas";
			} else {
				_flash.addFlashAttribute("error", "A user wtih this e-mail already exists.");
				return "redirect:/";
			}
		}
	}
	
}