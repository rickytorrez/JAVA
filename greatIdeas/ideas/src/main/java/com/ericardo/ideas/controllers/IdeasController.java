package com.ericardo.ideas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.ideas.models.Idea;
import com.ericardo.ideas.models.User;
import com.ericardo.ideas.services.IdeaService;
import com.ericardo.ideas.services.UserService;

@Controller
@RequestMapping("/ideas")
public class IdeasController {
	
	@Autowired
	private UserService _uS;
	
	@Autowired
	private IdeaService _iS;
	
	/***************************************** DASHBOARD *************************************/

	@RequestMapping("")
	public String dashboard(HttpSession _session, Model _model) {
		if(!_uS.isValid(_session)) {
			return "redirect:/";
		}
		
		User user = _uS.find( (Long) _session.getAttribute("id"));
		_model.addAttribute("user", user);
		_model.addAttribute("ideas", _iS.all());
		return "dashboard";
	}
	
	/************************************ ROUTE TO NEW IDEA **********************************/
	
	@RequestMapping("/new")
	public String ideaCreation(@ModelAttribute("idea") Idea idea, HttpSession _session, Model _model) {
		if(!_uS.isValid(_session)) {
			return "redirect:/";
		}
		
		User user = _uS.find( (Long) _session.getAttribute("id"));
		_model.addAttribute("user", user);
		
		return "newIdea";
	}
	
	/************************************** POST NEW IDEA ************************************/
	
	@PostMapping("/newIdea")
	public String newIdea(@ModelAttribute("idea") Idea idea, BindingResult _result, HttpSession _session) {
		
		User user = _uS.find( (Long) _session.getAttribute("id"));
		
		idea.setUser(user);
		_iS.create(idea);
		return "redirect:/ideas";
	}
	
	/*********************************** VIEW A SINGLE IDEA **********************************/
	
	@RequestMapping("/{id}")
	public String find(@PathVariable("id") Long id, Model _model, HttpSession _session) {
		if(!_uS.isValid(_session)) {
			return "redirect:/";
		}
		User user = _uS.find( (Long) _session.getAttribute("id"));
		Idea idea = _iS.find(id);
		
		System.out.println("User id: ");
		System.out.println(user.getId());
		
		System.out.println("Idea user id: ");
		System.out.println(idea.getUser().getId());
		
		_model.addAttribute("idea", idea);
		return "singleIdea";
	}
	
	/*********************************** EDIT A SINGLE IDEA **********************************/
	
	@RequestMapping("/{id}/edit")
	public String edit() {
		return "editIdea";
	}
	
	/**************************************** LIKE AN  IDEA **********************************/

	@PostMapping("/{id}/like")
	public String like(@PathVariable("id") Long id, HttpSession _session) {
		User user = _uS.find( (Long) _session.getAttribute("id"));
		Idea idea = _iS.find(id);
		
		List<User> usersLiked = idea.getFaveUsers();
		
		if(usersLiked.contains(user)) {
			usersLiked.remove(user);
			idea.setFaveUsers(usersLiked);
			_iS.update(idea);
			return "redirect:/ideas";
		}
		
		usersLiked.add(user);
		idea.setFaveUsers(usersLiked);
		_iS.update(idea);
		return "redirect:/ideas";
	}

	/**************************************** LIKE AN  IDEA **********************************/
	
	@RequestMapping("/ascending")
	public String ascending(HttpSession _session) {
		if(!_uS.isValid(_session)) {
			return "redirect:/";
		}
		User user = _uS.find( (Long) _session.getAttribute("id"));
		
		_iS.ascIdea();
		
		System.out.print(_iS.ascIdea());
		return "redirect:/ideas";
	}
	
	/******************************************** MY IDEAS **********************************/
	
	@RequestMapping("/userIdeas")
	public String myIdeas(HttpSession _session, Model _model) {
		if(!_uS.isValid(_session)) {
			return "redirect:/";
		}
		
		User user = _uS.find( (Long) _session.getAttribute("id"));
		
		_model.addAttribute("user", user);
		
		List<Idea> userIdeas = user.getIdeas();
		_model.addAttribute("ideas", userIdeas);
		System.out.println(userIdeas);
		
		return "ideas";
	}
	
}
