package com.ericardo.products_categories.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ericardo.products_categories.models.Category;
import com.ericardo.products_categories.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository _cR;
	
	// Constructor - could @Autowired go here? - Dependency injection - Null pointer error 
	public CategoryService(CategoryRepository _cR) {
		this._cR = _cR;
	}
	
	public void create(Category category) {
		_cR.save(category);
	}
	
	public Category find(Long id) {
		return _cR.findOne(id);
	}
	
	public void update(Category category) {
		_cR.save(category);
	}
	
	public void destroy(Category category) {
		_cR.delete(category);
	}
	
	public ArrayList<Category> all(){
		return (ArrayList<Category>) _cR.findAll();								// Casting to avoid errors
	}
	
}
