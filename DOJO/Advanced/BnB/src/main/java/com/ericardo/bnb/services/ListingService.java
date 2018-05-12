package com.ericardo.bnb.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ericardo.bnb.models.Listing;
import com.ericardo.bnb.repositories.ListingRepository;

@Service
public class ListingService {

	private ListingRepository _lR;
	
	public ListingService(ListingRepository _lR) {
		this._lR = _lR;
	}
	
	public void create(Listing listing) {
		_lR.save(listing);
	}
	
	public Listing find(Long id) {
		return (Listing) _lR.findOne(id);
	}
	
	public void update(Listing listing) {
		_lR.save(listing);
	}
	
	public void destroy(Long id) {
		_lR.delete(id);
	}
	
	public ArrayList<Listing> all(){
		return (ArrayList<Listing>) _lR.findAll();
	}
}
