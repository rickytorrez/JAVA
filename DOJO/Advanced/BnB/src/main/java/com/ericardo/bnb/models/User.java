package com.ericardo.bnb.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

	@Id
 	@GeneratedValue
 	private long id;
 	
	@Size(min=1, max=124, message="First name must be between 1 -124 characters.")
	private String firstname;
	
	@Size(min=1, max=124, message="Last name must be between 1 -124 characters.")
	private String lastname;
	
	@Email(message="Invalid E-mail format. Ex: example@example.com")
	private String email;
	
	@Size(min=8, max=124, message="Please provide a password longer than eight characters.")
	private String password;
	
 	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
 	private Date createdAt;
 	
 	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
 	private Date updatedAt;
 	
 	// Persist and Update //
 	
 	@PrePersist
 	public void onCreate() {
 		this.createdAt = new Date();
 	}
 	
 	@PreUpdate
 	public void onUpdate() {
 		this.updatedAt = new Date();
 	}

 	// Setters and Getters // 
 	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	// Empty Constructor //
	
	public User() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
}
