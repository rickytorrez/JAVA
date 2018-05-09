package com.ericardo.products_categories.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericardo.products_categories.models.Category;
import com.ericardo.products_categories.models.Product;
import com.ericardo.products_categories.services.CategoryService;
import com.ericardo.products_categories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService _pS;
	private CategoryService _cS;
	
	public ProductController(ProductService _pS, CategoryService _cS) {
		this._pS = _pS;
		this._cS = _cS;
	}
	
	@RequestMapping("/new")			
	public String products(@ModelAttribute ("product") Product product) {												// Creates a blank instance of an object
		return "products";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {					// Binding result refers to user input
		if(result.hasErrors() ) {																					// Validation
			return "products";
		}
		_pS.create(product);
		return "redirect:/products/new";
	}
	
	@RequestMapping("/{id}")																							// Shows product by id
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("categories", _cS.all());																	// Gets all the categories and let's us query for them on line 21
		model.addAttribute("product", _pS.find(id));																	// Adds product of the route to the page, refers to line 11 in the showproduct jsp
		return "showproduct";
	}
	
	@PostMapping("{product_id}/join")																				// Route to make our join
	public String join(@RequestParam("category_id") Long category_id, @PathVariable("product_id") Long product_id) {	// RequestParams pulls stuff out of our form, all we care about is the category id on line 20, PathVariable let's you grab the id from the url 
		
		Product product = _pS.find(product_id);																		// Find the product by its id
		List<Category> categories = product.getCategories();															// Make a list that contains categories to push something into it later - categories is the foreign key
		Category category = _cS.find(category_id);																	// Find the category you clicked on
		categories.add(category);																					// Adds a category to the product's category
		
		product.setCategories(categories);																			// Sets categories arraylist to categories in the model
		
		_pS.update(product);
		return "redirect:/products/"+product_id;
		
	}
}
