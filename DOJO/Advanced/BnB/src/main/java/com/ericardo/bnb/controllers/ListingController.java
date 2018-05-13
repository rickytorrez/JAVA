package com.ericardo.bnb.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericardo.bnb.models.Listing;
import com.ericardo.bnb.models.Review;
import com.ericardo.bnb.models.User;
import com.ericardo.bnb.services.ListingService;
import com.ericardo.bnb.services.ReviewService;
import com.ericardo.bnb.services.UserService;

@Controller
@RequestMapping("/listings")
public class ListingController {
	
	private ListingService _lS;
	private UserService _uS;
	private ReviewService _rS;
	
	public ListingController(ListingService _lS, UserService _uS, ReviewService _rS) {
		this._lS = _lS;
		this._uS = _uS;
		this._rS = _rS;
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
		System.out.println("USER");
		System.out.println(user.getFirstname());
		
		System.out.println("HITTING IT");
		
		_model.addAttribute("user", user);
		_model.addAttribute("listing", new Listing());
		
		return "host";
	}
	
	@PostMapping("")																	// Creating Listing for hosts
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
				listing.setAverage(0);												// Sets average rating to 0, for reviews to be averaged   <====			
				_lS.create(listing);													// Create listing
				return "redirect:/listings/host";
			}
		}
	}

	@RequestMapping("{id}")															// Method for letting user a single review
	public String find(@PathVariable("id") Long id, Model _model, HttpSession _session) {
		if(_session.getAttribute("id") != null) {									// If statement to show log out and leave a review tags
			User user = _uS.find( (long) _session.getAttribute("id"));
			_model.addAttribute("user", user);
		}
		
		_model.addAttribute("listing", _lS.find(id));								// Used to display the particular review
		
		return "reviews";
	}
	
	@RequestMapping("{id}/review")													// Method for routing us to make a review
	public String review(@PathVariable("id") Long id, Model _model, HttpSession _session) {
		if(_session.getAttribute("id") != null) {									// If you're a guess
			User user = _uS.find( (long) _session.getAttribute("id"));				// find you by id
			_model.addAttribute("user", user);										// spit your id out
		} else {																		// If not a guess or a host
			return "redirect:/listings/"+id;											// take you to see the listing
		}
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();						// Array to use for rating
		for(int i=1;i<6;i++) 
			numbers.add(i);
	
		_model.addAttribute("numbers", numbers);										// Send out the array for use on jsp
		_model.addAttribute("listing", _lS.find(id));
		_model.addAttribute("review", new Review());									// Blank review to bind the the empty modelAttribute on the review.jsp
		return "review";
	}
	
	@PostMapping("/{id}/review")														// Method used for creating a review
	public String createReview(@PathVariable("id") Long id, @ModelAttribute("review") Review review, BindingResult _result, HttpSession _session ) {
		if(_session.getAttribute("id") == null) {									// Checks for user in session
			return "/listings/"+id+"/review";
		}
		
		User user = _uS.find( (long) _session.getAttribute("id"));					// Sets User in session to variable user
		
		if(user.isHost()) {															// Host validation 
			return "/listings";
		}
		
		if(_result.hasErrors()) {													// Error Validation
			System.out.print("ERRORS:   ");
			System.out.print(_result.hasErrors());
			
			return "/review";
		} else {
			
			Listing listing = _lS.find(id);											// Find the listing by its id
			
			review.setId(null);														// By setting id to null, STS creates a new instance and allows to leave more than one review
			
			List<Review> reviews = listing.getReviews();								// Gets list of reviews
			reviews.add(review);														// Adds review being created
			listing.setReviews(reviews);												// Returns new list of reviews
			
			double sum = 0;															// Initiates sum
			
			for(Review rev: listing.getReviews()) {									// Loop all of our reviews
				sum += rev.getRating();												// Add the sum by its rating
			}
			
			sum += review.getRating();												// Add the new rating to the review
			sum /= listing.getReviews().size()+1;									// Get the average -- +1 refers to the new review
//			listing.setAverage(sum);													// Update our listing
			
			listing.setAverage(sum);
			
			
			review.setListing(listing);												// Foreign Key for Listing
			review.setUser(user);													// Foreign Key for User
			_rS.create(review);														// Creates a review
			
			_lS.update(listing);														// Use Listing service to update the listing
			
			return "redirect:/listings/";	
		}
	}
	
	// Search for part of a word in a string
	public boolean scrub(String needle, String haystack) {							// Needle represents the thing you're looking for, haystack represents where you're looking for
		needle = needle.toLowerCase();												// Lowercase the thing you're looking for
		
		for(int j=0; j<haystack.length()-needle.length()+1;j++) {					// for loops and moves string over to find the word you're looking for inside the string
			String result = haystack.substring(j, j+needle.length()).toLowerCase();
			// Found match and listing isnt already pushed
			if(result.indexOf(needle) != -1) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping("/search")														// Search box route (GET)
	public String search(@RequestParam("search") String search, HttpSession _session, Model _model) {
		search = search.toLowerCase();
		
		User user;
		
		if(_session.getAttribute("id") != null) {
			user = _uS.find( (long) _session.getAttribute("id"));
			_model.addAttribute("user", user);
		}
		
		ArrayList<Listing> allListings = _lS.all();
		ArrayList<Listing> listings = new ArrayList<Listing>();
		
		for(Listing listing: allListings) {
			if(scrub(search, listing.getAddress()) && !listings.contains(listing)) {					// Calls scrub function to loop for address
				listings.add(listing);
			}
			if(scrub(search, listing.getSize()) && !listings.contains(listing)) {						// Calls scrub function to loop for size
				listings.add(listing);
			}
			if(scrub(search, Double.toString(listing.getCost())) && !listings.contains(listing)) {	// Calls scrub function to loop for cost
				listings.add(listing);
			}
		}
		
		_model.addAttribute("listings", listings);
		
		return "guest";
	}
		
}
