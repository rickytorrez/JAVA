package com.ericardo.ideas.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ericardo.ideas.models.User;
import com.ericardo.ideas.repositories.UserRepository;


@Service
public class UserService {
	
	private UserRepository _uR;
	private BCryptPasswordEncoder _bcrypt;
	
	public UserService(UserRepository _uR) {
		this._uR = _uR;
		this._bcrypt = encoder();
	}
	
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	public boolean isMatch(String password, String dbPassword) {
		if(_bcrypt.matches(password, dbPassword)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void login(HttpSession _session, Long id) {
		_session.setAttribute("id", id);
	}
	
	public void logout(HttpSession _session) {
		_session.setAttribute("id", null);
	}
	
	public boolean isValid(HttpSession _session) {
		if(_session.getAttribute("id") == null ) {
			return false;
		} else {
			return true;
		}
	}
	
	/************************************* STANDARD CRUD *************************************/
	
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
	
	public User findByUsername(String username) {
		return (User) this._uR.findByUsername(username);
	}
	
	public void update(User user) {
		this._uR.save(user);
	}
	
	public void destroy(Long id) {
		this._uR.delete(id);
	}
	
}