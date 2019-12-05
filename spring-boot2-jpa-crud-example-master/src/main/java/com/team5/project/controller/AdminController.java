package com.team5.project.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.AddCustomer;
import com.team5.project.model.Admin;
import com.team5.project.model.Transaction;
import com.team5.project.repository.AdminRepository;
import com.team5.project.service.AdminService;


@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired 
	private AdminService adminservice;
	

	@PostMapping("/addAdmin")
	public Admin addAccount(@Valid @RequestBody Admin admin) {
		System.out.println("Admin obj: "+ admin);	
		return adminservice.addAccount(admin);
		 
	}
	
	@PostMapping("/manualRefunds")
	public ResponseEntity<Transaction> addAccount(@Valid @RequestBody AddCustomer manual) throws ResourceNotFoundException {
		System.out.println("Admin obj: "+ manual);	
		return adminservice.addRefunds(manual);
		 
	}
	
	@GetMapping("/checkHealth")
	public ResponseEntity<String> checkHealth() throws ResourceNotFoundException {
			
		return new ResponseEntity<>(
		          "Server Up Running", 
		          HttpStatus.OK);
		 
	}
	

	


	
}
