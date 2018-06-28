package com.ericardo.greatIdeas.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericardo.greatIdeas.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	ArrayList<User> findAll();
	
}
