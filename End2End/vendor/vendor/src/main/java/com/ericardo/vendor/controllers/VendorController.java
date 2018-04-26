package com.ericardo.vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericardo.vendor.entities.Vendor;
import com.ericardo.vendor.service.VendorService;

@Controller
public class VendorController {
	
	@Autowired
	VendorService _vS;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVendor";
	}
	
	@RequestMapping("/saveVend")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		Vendor vendorSaved = _vS.saveVendor(vendor);
		String msg = "Vendor Saved with id: " + vendorSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createVendor";
	}
	
	@RequestMapping("/displayVendors")
	public String displayVendor(ModelMap modelMap) {
		List<Vendor> vendors = _vS.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendor";
	}
	
	@RequestMapping("deleteVendor")
	public String deleteVendor(@RequestParam("id") int id, ModelMap modelMap) {
		Vendor vendor = new Vendor();
		vendor.setId(id);
		_vS.deleteVendor(vendor);
		List<Vendor> vendors = _vS.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendor";
	}
	
	// Routes to new page
	@RequestMapping("/showVendor")
	public String editVendor(@RequestParam("id") int id, ModelMap modelMap) {
		Vendor vendor = _vS.getVendorById(id);
		modelMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
	@RequestMapping("/updateVend")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		_vS.updateVendor(vendor);
		List<Vendor> vendors = _vS.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendor";
	}
	
}









