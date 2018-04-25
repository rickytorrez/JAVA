package com.ericardo.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericardo.location.entities.Location;
import com.ericardo.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository _lr;

	@Override
	public Location saveLocation(Location location) {
		return _lr.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return _lr.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		_lr.delete(location);

	}

	@Override
	public Location getLocationById(int id) {
		return _lr.findOne(id);
	}

	@Override
	public List<Location> getAllLocations() {
		return _lr.findAll();
	}

	public LocationRepository get_lr() {
		return _lr;
	}

	public void set_lr(LocationRepository _lr) {
		this._lr = _lr;
	}

}
