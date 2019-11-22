package com.team5.project.service;

import org.springframework.http.ResponseEntity;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.AddCustomer;
import com.team5.project.model.Customer;

public interface CustomerService {

	public Customer addAccount  (AddCustomer addCust) throws ResourceNotFoundException;
	public ResponseEntity<Customer> closeCustomerAccount(Customer customerObj) throws ResourceNotFoundException;
	
	
}
