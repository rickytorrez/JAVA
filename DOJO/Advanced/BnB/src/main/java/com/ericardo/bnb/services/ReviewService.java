package com.ericardo.bnb.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ericardo.bnb.models.Review;
import com.ericardo.bnb.repositories.ReviewRepository;

@Service
public class ReviewService {

	private ReviewRepository _rR;
	
	public ReviewService(ReviewRepository _rR) {
		this._rR = _rR;
	}
	
	public void create(Review review) {
		_rR.save(review);
	}
	
	public Review find(Long id) {
		return (Review) _rR.findOne(id);
	}
	
	public void update(Review review) {
		_rR.save(review);
	}
	
	public void destroy(Long id) {
		_rR.delete(id);
	}
	
	public ArrayList<Review> all(){
		return (ArrayList<Review>) _rR.findAll();
	}

}
