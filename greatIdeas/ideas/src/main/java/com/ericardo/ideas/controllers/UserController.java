package com.ericardo.ideas.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ericardo.ideas.models.User;
import com.ericardo.ideas.services.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService _uS;
	
	
	/*************************************** POST NEW USER ***********************************/
	@PostMapping("/new")
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

	/*************************************** LOGIN USER **************************************/
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession _session, RedirectAttributes _flash) {
		if(email.length() < 1) {
			_flash.addFlashAttribute("error", "E-mail cannot be blank.");
			return "redirect:/";
		}
		
		User user = _uS.findByEmail(email);
		
		if(user == null) {
			_flash.addFlashAttribute("error", "No user with this e-mail found.");
			return "redirect:/";
		} else {
			if(_uS.isMatch(password, user.getPassword())) {
				_uS.login(_session, user.getId());
				return "redirect:/ideas";
				
			} else {
				_flash.addFlashAttribute("error", "Invalid Credentials");
				return "redirect:/";
			}
		}
	}
	
	/*************************************** LOGOUT USER *************************************/

	@RequestMapping("/logout")
	public String logout(HttpSession _session) {
		_session.setAttribute("id", null);
		return "redirect:/";
	}
	
}