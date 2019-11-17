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


@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	

	@PostMapping("/addAccount")
	public Customer addAccount(@Valid @RequestBody AddCustomer addCust) throws ResourceNotFoundException {
		Long adminId = addCust.getAdminId();
		String adminPass = addCust.getAdminPass();
		Customer customer = addCust.getCust();
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("No Admin found for this AdminID  :: " + adminId));
		
		if(admin.getPassword() == adminPass) {
			System.out.println("customer obj: "+ customer);		
			return customerRepository.save(customer);
		}else {
			System.out.println("ADMIN CREDENTIALS MISMATCH");
			throw new ResourceNotFoundException(adminPass); 
		}
		
		
	}
	
	
	@PostMapping("/closeAccount")
	public ResponseEntity<Customer> closeCustomerAccount(@Valid @RequestBody Customer customerObj) throws ResourceNotFoundException{
		Long accountNumber = customerObj.getAccountNumber();
		System.out.println("Account number: "+accountNumber);
		System.out.println("Cust Obj: "+customerObj);
		Customer customer = customerRepository.findById(accountNumber)
				.orElseThrow(() -> new ResourceNotFoundException("No Customer found for this Account Number :: " + accountNumber));

		customer.setStatus("Inactive");
		
		final Customer closedCustomerAccount = customerRepository.save(customer);
		return ResponseEntity.ok(closedCustomerAccount);
	}

	
}
