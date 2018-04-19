package com.ericardo.customerDAL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ericardo.customerDAL.entities.Customer;
import com.ericardo.customerDAL.repos.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerdalApplicationTests {

	@Autowired
	private CustomerRepository _cR;
	
	// Create a customer
	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		customer.setName("Jonathan");
		customer.setEmail("jon@jon.com");
		
		_cR.save(customer);
	}
	
	// Read a customer
	@Test
	public void testReadCustomer() {
		
		Customer customer = _cR.findOne(1l);
		System.out.println(customer);
	}

	// Updates a customer
	@Test
	public void testUpdateCustomer() {
		Customer customer = _cR.findOne(1l);
		customer.setName("Eugene");
		
		_cR.save(customer);
	}
	
	// Deletes a customer
	@Test
	public void testDeleteCustomer() {
		
		_cR.delete(1l);
	}
	
}