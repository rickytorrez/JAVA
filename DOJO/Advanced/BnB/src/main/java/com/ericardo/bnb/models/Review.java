package com.ericardo.bnb.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ericardo.bnb.models.Listing;
import com.ericardo.bnb.models.User;

@Entity
public class Review {

	/*************************************** ATTRIBUTES **************************************/
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, max=255, message="Please provide a review.")
	private String description;
	
	@NotNull(message="Please provide a rating.")
	private int rating;
	 	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	 	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	/************************************* RELATIONSHIPS *************************************/
	 	
	/************************************* with listing **************************************/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="listing_id")
	private Listing listing;
	 	
	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
	/************************************** with user ***************************************/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
	 	
	public Review() {
	 	this.createdAt = new Date();
	 	this.updatedAt = new Date();
	}
}
