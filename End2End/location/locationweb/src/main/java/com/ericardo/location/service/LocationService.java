package com.ericardo.location.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ericardo.location.entities.Location;

@Service
public interface LocationService {

	// Save Location
	Location saveLocation(Location location);

	// Update Location
	Location updateLocation(Location location);

	// Delete Location
	void deleteLocation(Location location);

	// Get Location
	Location getLocationById(int id);

	// List of locations
	List<Location> getAllLocations();

}
