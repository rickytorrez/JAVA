package com.ericardo.vendor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericardo.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
