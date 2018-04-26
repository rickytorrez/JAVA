package com.ericardo.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericardo.location.entities.Location;
import com.ericardo.location.repos.LocationRepository;
import com.ericardo.location.service.LocationService;
import com.ericardo.location.util.EmailUtil;
import com.ericardo.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService _ls;
	
	@Autowired
	LocationRepository _lR;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext _sC;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = _ls.saveLocation(location);
		String msg = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.snedEmail(
				"nine1sixdc@gmail.com", 
				"Location Saved", 
				"Location Saved successfully and about to return a response");
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
		Location location = new Location();
		location.setId(id);
		_ls.deleteLocation(location);														// invoke service, retrieve and pass location
		List<Location> locations = _ls.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";											
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdatePage(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = _ls.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		_ls.updateLocation(location);
		List<Location> locations = _ls.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = _sC.getRealPath("/");
		List<Object[]> data = _lR.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
	
}
