package com.ericardo.ideas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Idea {

	/*************************************** ATTRIBUTES **************************************/
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=3, max=30, message="Please provide an idea")
	private String content;
	 	
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
	
	/*************************************** favorites ***************************************/

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="user_fave_ideas",
			joinColumns = @JoinColumn(name = "idea_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> faveUsers;
	
	public List<User> getFaveUsers() {
		return faveUsers;
	}

	public void setFaveUsers(List<User> faveUsers) {
		this.faveUsers = faveUsers;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	 	
	public Idea() {
	 	this.createdAt = new Date();
	 	this.updatedAt = new Date();
	}
}
