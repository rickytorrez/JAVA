package com.ericardo.products_categories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.products_categories.models.Category;
import com.ericardo.products_categories.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	private CategoryService _cS;
	
	// Constructor
	public CategoryController(CategoryService _cS) {
		this._cS = _cS;
	}
	
	@RequestMapping("/new")
	public String categories(Model model) {
		model.addAttribute("category", new Category() );														// Blank object to send to page
		System.out.println("is it clicking?");
		return "categories";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {				
		
		if(result.hasErrors()) {
			return "categories";																				// If there's errors re-render the page	
		}
		_cS.create(category);																				// If no errors, create the category, passed on line 34 
		return "redirect:/categories/new";
	}
	

}
