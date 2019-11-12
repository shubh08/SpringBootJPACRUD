package com.team5.project.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.project.model.Customer;
import com.team5.project.repository.CustomerRepository;


@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	

	@PostMapping("/addAccount")
	public Customer addAccount(@Valid @RequestBody Customer customer) {
		System.out.println("customer obj: "+ customer);
		return customerRepository.save(customer);
	}

	
}
