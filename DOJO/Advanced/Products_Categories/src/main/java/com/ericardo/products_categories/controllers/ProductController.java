package com.ericardo.products_categories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.products_categories.models.Product;
import com.ericardo.products_categories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService _pS;
	
	public ProductController(ProductService _pS) {
		this._pS = _pS;
	}
	
	@RequestMapping("/new")
	public String products(@ModelAttribute ("product") Product product) {								// Creates a blank instance of an object
		return "products";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {	// Binding result refers to user input
		if(result.hasErrors() ) {																	// Validation
			return "products";
		}
		_pS.create(product);
		return "redirect:/products/new";
	}
	
}
