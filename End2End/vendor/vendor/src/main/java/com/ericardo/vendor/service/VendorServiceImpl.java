package com.ericardo.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericardo.vendor.entities.Vendor;
import com.ericardo.vendor.repos.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	private VendorRepository _vR;

	@Override
	public Vendor saveVendor(Vendor vendor) {
		return _vR.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return _vR.save(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		_vR.delete(vendor);
	}

	@Override
	public Vendor getVendorById(int id) {
		return _vR.findOne(id);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return _vR.findAll();
	}

	public VendorRepository get_vR() {
		return _vR;
	}

	public void set_vR(VendorRepository _vR) {
		this._vR = _vR;
	}

}
