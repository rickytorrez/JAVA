package com.ericardo.ideas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {
	
	/*************************************** ATTRIBUTES **************************************/
	@Id
	@GeneratedValue
	private Long id;
	
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
	
	@Transient																						
	@Size(min=8, max=124, message="Password confirmation must be between 8 and 124 characters")
	private String confirm;

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	/************************************* RELATIONSHIPS ************************************/
	
	/***************************************** with idea ************************************/
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Idea> ideas;
	
	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}
	
	/************************************ with favorites ************************************/
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_fave_ideas",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "idea_id")
	)
	private List<Idea> faveIdeas;
	
	public List<Idea> getFaveIdeas() {
		return faveIdeas;
	}

	public void setFaveIdeas(List<Idea> faveIdeas) {
		this.faveIdeas = faveIdeas;
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
	
	/********************************** EMPTY CONSTRUCTOR  **********************************/
	
	public User() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
}