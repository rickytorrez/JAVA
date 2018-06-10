package com.ericardo.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	// counter to determine user's id
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Carmen", new Date()));
		users.add(new User(2, "Andrei", new Date()));
		users.add(new User(3, "Paolo", new Date()));
	}
	
	// find all
	public List<User> findAll(){
		return users;
	}
	
	// create a user
	// if their id is null, set new id to increment the number of the last index
	// add user to the users array and save user
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	// find one
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
}
