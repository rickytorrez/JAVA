package com.ericardo.products_categories.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ericardo.products_categories.models.Product;
import com.ericardo.products_categories.repositories.ProductRepository;

@Service
public class ProductService {

private ProductRepository _pR;
	
	// Constructor - could @Autowired go here? - Dependency injection - Null pointer error 
	public ProductService(ProductRepository _pR) {
		this._pR = _pR;
	}
	
	public void create(Product product) {
		System.out.print("Create @ _pS " + product.getName());
		System.out.print("Create @ _pS " + product.getDescription());
		_pR.save(product);
	}
	
	public Product find(Long id) {
		return _pR.findOne(id);
	}
	
	public void update(Product product) {
		_pR.save(product);
	}
	
	public void destroy(Product product) {
		_pR.delete(product);
	}
	
	public ArrayList<Product> all(){
		return (ArrayList<Product>) _pR.findAll();								// Casting to avoid errors
	}
	
}
