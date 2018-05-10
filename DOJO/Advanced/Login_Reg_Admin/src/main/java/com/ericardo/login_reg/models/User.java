package com.ericardo.login_reg.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.ericardo.login_reg.models.Role;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1, max=124, message="Please provide a first name")
	private String firstname;
	
	@Size(min=1, max=124, message="Please provide a last name")
	private String lastname;
	
	@Size(min=1, max=124, message="Please provide a username")
	private String username;
	
	@Email(message="Invalid E-mail format. Ex: user@user.com")
	private String email;
	
	@Size(min=8, max=124, message="Password must be between 8 and 124 characters")
	private String password;
	
	@Transient																						// Use transient to not save to the database
	@Size(min=8, max=124, message="Password confirmation must be between 8 and 124 characters")
	private String confirm;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	// Join - Join Setters and Getters
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "user_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private List<Role> roles;
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public List<Role> getRoles(){
		return roles;
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
	
	// Setters and Getters

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	
	// Blank Constructor
	
	public User() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
}
