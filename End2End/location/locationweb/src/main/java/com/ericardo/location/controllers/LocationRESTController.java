package com.ericardo.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericardo.location.entities.Location;
import com.ericardo.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	@Autowired
	LocationRepository _lR;
	
	// GET
	@GetMapping	// Bind the http get method to this method
	public List<Location> getLocaitons(){
		return _lR.findAll();
	}
	
	// POST
	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return _lR.save(location);
	}
	
	// UPDATE
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return _lR.save(location);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		_lR.delete(id);
	}
	
	// FIND ONE
	@GetMapping("/{id}")
	public Location getOneLocation(@PathVariable("id") int id) {
		return _lR.findOne(id);
	}
	
	
}
