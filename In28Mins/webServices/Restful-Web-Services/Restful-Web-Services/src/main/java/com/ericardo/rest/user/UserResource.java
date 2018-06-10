package com.ericardo.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService _uDS;
	
	// get All Users
	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return _uDS.findAll();	
	}
	
	// get a single user
	// GET /users/{id}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return _uDS.findOne(id);
	}
}
