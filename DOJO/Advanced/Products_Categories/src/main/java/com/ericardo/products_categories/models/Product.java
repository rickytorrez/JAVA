package com.ericardo.products_categories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ericardo.products_categories.models.Category;		// Imports the Category Model since it's being used on the ManyToMany Join 

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1, max=255, message="Name cannot be blank")
	private String name;
	
	@Size(min=1, max=255, message="Please provide a description")
	private String description;
	
	@NotNull
	double price;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	// Relationships - Joins
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="categories_products",							// Name of table
			joinColumns=@JoinColumn(name="product_id"),			// Foreign Key - Name of your model
			inverseJoinColumns=@JoinColumn(name="category_id")	// Opposite model
	)
	private List<Category> categories;							// One product can belong to many categories
	
	public List<Category> getCategories(){						// Set getter and setters to have access to the joins
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	// Persist and Update
	
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// Constructor
	
	public Product() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
