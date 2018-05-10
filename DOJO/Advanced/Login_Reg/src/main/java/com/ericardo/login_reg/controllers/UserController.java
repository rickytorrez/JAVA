package com.ericardo.login_reg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.login_reg.models.User;
import com.ericardo.login_reg.services.UserService;

@Controller
public class UserController {
	
	private UserService _uS;
	
	public UserController(UserService _uS) {
		this._uS = _uS;
	}

    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
    		System.out.println("is it clicking?" );
        return "registrationPage";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "registrationPage";
        }
        _uS.saveWithUserRole(user);
        return "redirect:/login";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "loginPage";
    }
}

