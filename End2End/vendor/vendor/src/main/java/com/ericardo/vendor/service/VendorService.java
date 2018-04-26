package com.ericardo.vendor.service;

import java.util.List;

import com.ericardo.vendor.entities.Vendor;

public interface VendorService {

	// Save Vendor
	Vendor saveVendor(Vendor vendor);
	
	// Update Vendor
	Vendor updateVendor(Vendor vendor);
	
	// Delete Vendor
	void deleteVendor(Vendor vendor);
	
	// Get Vendor
	Vendor getVendorById(int id);
	
	// List of vendors
	List<Vendor> getAllVendors();
}
