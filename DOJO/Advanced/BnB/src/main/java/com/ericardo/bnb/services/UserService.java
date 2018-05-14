package com.ericardo.bnb.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ericardo.bnb.models.User;
import com.ericardo.bnb.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository _uR;
	private BCryptPasswordEncoder _bcrypt;
	
	public UserService(UserRepository _uR) {
		this._uR = _uR;
		this._bcrypt = encoder();															// Creating instance of bcrypt manually on line 19 
	}
	
	public BCryptPasswordEncoder encoder() {													// Method used to create instance
		return new BCryptPasswordEncoder();
	}
	
	public boolean isMatch(String password, String dbPassword) {								// Takes a password from a form and matches to the one in the db
		if(_bcrypt.matches(password, dbPassword)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void login(HttpSession _session, Long id) {										// Use session to store the user id of the person logged in
		_session.setAttribute("id", id);
	}
	
	public void logout(HttpSession _session) {												// Kicks you out of session
		_session.setAttribute("id", null);
	}

	public String redirect() {																// Returns a string that redirects you to the dashboard
		return "redirect:/users/new";
	}
	
	public boolean isValid(HttpSession _session) {											// Compares to see if you're in session
		if(_session.getAttribute("id") == null ) {
			return false;
		} else {
			return true;
		}
	}
	
	// Standard CRUD //
	
	public User create(User user) {
		user.setPassword(_bcrypt.encode(user.getPassword()));
		return this._uR.save(user);
	}
	
	public ArrayList<User> all(){
		return (ArrayList<User>) this._uR.findAll();
	}
	
	public User find(Long id) {
		return (User) this._uR.findOne(id);
	}
	
	public User findByEmail(String email) {
		return (User) this._uR.findByEmail(email);
	}
	
	public void update(User user) {
		this._uR.save(user);
	}
	
	public void destroy(Long id) {
		this._uR.delete(id);
	}
	
}
