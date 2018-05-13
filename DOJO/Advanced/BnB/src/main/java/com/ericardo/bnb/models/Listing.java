package com.ericardo.bnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import com.ericardo.bnb.models.User;
import com.ericardo.bnb.models.Review;

@Entity
public class Listing {

	/*************************************** ATTRIBUTES **************************************/

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1, max=255, message="Please provide an address.")
	private String address;
	
	@Size(min=1, max=255, message="Please provide a description.")
	private String description;
	
	@NotNull(message="Please provide a cost")
	private double cost;
	
	@Size(min=1, max=255, message="Please provide the size of your property.")
	private String size;
	
	private double average;

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	 	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	
	/************************************* RELATIONSHIPS *************************************/
	
	/*************************************** with user ***************************************/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/************************************* with review **************************************/
	
	@OneToMany(mappedBy="listing", fetch=FetchType.LAZY)												// Each review should have a reference to the specific listing it belongs to
	private List<Review> reviews;
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	/********************************* PERSIST AND UPDATE  **********************************/

	@PrePersist
	public void onCreate() {
	 	this.createdAt = new Date();
	}
	 	
	@PreUpdate
	public void onUpdate() {
	 	this.updatedAt = new Date();
	}

	/******************************** SETTERS AND GETTERS  **********************************/
	 	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
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

	/********************************** EMPTY CONSTRUCTOR  **********************************/

	public Listing() {
	 	this.createdAt = new Date();
	 	this.updatedAt = new Date();
	}
}
