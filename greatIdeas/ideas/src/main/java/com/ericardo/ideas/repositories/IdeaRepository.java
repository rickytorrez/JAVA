package com.ericardo.ideas.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericardo.ideas.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	
	@Query(value="SELECT idea_id, COUNT(1) FROM 062818_ideas.user_fave_ideas GROUP BY idea_id", nativeQuery=true)
	ArrayList<Idea> sortAscending();
	
	@Query(value="SELECT idea_id, COUNT(1) FROM 062818_ideas.user_fave_ideas GROUP BY idea_id DESC", nativeQuery=true)
	ArrayList<Idea> sortDescending();
}
