package com.ericardo.bnb.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.bnb.models.Listing;
import com.ericardo.bnb.models.User;
import com.ericardo.bnb.services.ListingService;
import com.ericardo.bnb.services.UserService;

@Controller
@RequestMapping("/listings")
public class ListingController {
	
	private ListingService _lS;
	private UserService _uS;
	
	public ListingController(ListingService _lS, UserService _uS) {
		this._lS = _lS;
		this._uS = _uS;
	}
	
	@RequestMapping("")																// Listing route 
	public String listings(HttpSession _session, Model _model) {
		User user;
		
		if(_session.getAttribute("id") != null ) {									// If user is not null
			user = _uS.find( (long) _session.getAttribute("id"));						// use this method to
			_model.addAttribute("user", user);										// show the logout button
		}
		_model.addAttribute("listings", _lS.all());									// Use model to display all the listings in our jsp
		return "guest";
	}
	
	
	@RequestMapping("/host")															// Host route to dashboard
	public String host(HttpSession _session, Model _model) {
		if(_session.getAttribute("id") == null) {									// Kick you out if you're not in session
			return "redirect:/users/new";
		}
		
		User user = _uS.find( (long) _session.getAttribute("id") );					// Find the id of the user in session
		
		if (!user.isHost()) {														// If user is not a host, redirect to listings
			return "redirect:/listings";
		}
		
		_model.addAttribute("user", user);
		_model.addAttribute("listing", new Listing());
		
		return "host";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("listing") Listing listing, BindingResult _result, HttpSession _session) {
		if(_session.getAttribute("id") == null) {									// If you got here and not logged in, redirect you to log in or create account
			return "redirect:/users/new";
		}
		
		User user = _uS.find( (long) _session.getAttribute("id"));					// Look up the person that's logged in
		
		if(!user.isHost()) {															// If you're not a host, take you back to listings
			return "redirect:/listings";
		} else {																		// If you're a host
			if(_result.hasErrors()) {												// Will show you errors and return 
				return "/listings/host";		
			} else {																	// If no errors
				listing.setUser(user);												// Set foreign key - Setters and getters on model!
				_lS.create(listing);													// Create listing
				return "redirect:/listings/host";
			}
		}
	}

}
