package com.ericardo.login_reg.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;
import com.ericardo.login_reg.models.User;

@Entity
public class Role {

	@Id
 	@GeneratedValue
 	private long id;
	
	private String name;
 	
 	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
 	private Date createdAt;
 	
 	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
 	private Date updatedAt;
 	
	// Join - Join Setters and Getters
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers(){
		return users;
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

	public void setName(String name) {
		this.name = name;
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
}
