package com.team5.project.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.AddCustomer;
import com.team5.project.model.Admin;
import com.team5.project.model.Transaction;

public interface AdminService {

	public Admin addAccount(Admin admin);

	public ResponseEntity<Transaction> addRefunds(@Valid AddCustomer manual) throws ResourceNotFoundException;
}
