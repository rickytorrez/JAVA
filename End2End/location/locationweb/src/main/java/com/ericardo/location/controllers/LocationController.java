package com.ericardo.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericardo.location.entities.Location;
import com.ericardo.location.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService _ls;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = _ls.saveLocation(location);
		String msg = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = _ls.getAllLocations();
		modelMap.addAttribute("locations", locations);
		System.out.println(locations);
		return "displayLocations";
	}

	@RequestMapping("deleteLocation")
	public String deleleLocation(@RequestParam("id") int id, ModelMap modelMap) {				// Retrieve parameter from ids
//		Location location = _ls.getLocationById(id);											// Pass location once it is found by the new id
		Location location = new Location();
		location.setId(id);
		_ls.deleteLocation(location);														// invoke service, retrieve and pass location
		List<Location> locations = _ls.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";											
	}
	
}
