package com.team5.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.AddCustomer;
import com.team5.project.model.Admin;
import com.team5.project.model.Customer;
import com.team5.project.repository.AdminRepository;
import com.team5.project.repository.CustomerRepository;
import com.team5.project.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	CustomerService customerservice;

	@PostMapping("/addAccount")
	public Customer addAccount(@Valid @RequestBody AddCustomer addCust) throws ResourceNotFoundException {

		return customerservice.addAccount(addCust);

	}

	@PostMapping("/closeAccount")
	public ResponseEntity<Customer> closeCustomerAccount(@Valid @RequestBody Customer customerObj)
			throws ResourceNotFoundException {
		return customerservice.closeCustomerAccount(customerObj);
	}

}
