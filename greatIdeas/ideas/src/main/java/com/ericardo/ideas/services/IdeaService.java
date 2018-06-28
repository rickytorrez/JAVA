package com.ericardo.ideas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericardo.ideas.models.Idea;
import com.ericardo.ideas.repositories.IdeaRepository;

@Service
public class IdeaService {
	
	@Autowired
	private IdeaRepository _iR;
	
	/************************************ STANDARD CRUD **************************************/
	
	public void create(Idea idea) {
		_iR.save(idea);
	}
	
	public Idea find(Long id) {
		return _iR.findOne(id);
	}
	
	public void update(Idea idea) {
		_iR.save(idea);
	}
	
	public void destroy(Long id) {
		_iR.delete(id);
	}
	
	public ArrayList<Idea> all(){
		return (ArrayList<Idea>) _iR.findAll();
	}
	
	public ArrayList<Idea> ascIdea(){
		return (ArrayList<Idea>) _iR.sortAscending();
	}
	
	public ArrayList<Idea> desIdea(){
		return (ArrayList<Idea>) _iR.sortDescending();
	}
	
}
