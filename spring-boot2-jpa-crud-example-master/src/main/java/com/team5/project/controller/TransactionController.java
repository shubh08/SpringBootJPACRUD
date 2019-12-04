package com.team5.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.Transaction;
import com.team5.project.repository.TransactionRepository;
import com.team5.project.service.TransactionService;


@RestController
@RequestMapping("customer")
public class TransactionController {
	

@Autowired
TransactionService transactionservice;

@Autowired
TransactionRepository transactionRepository;
	
	@PostMapping("/addTransaction")
	public ResponseEntity<Transaction> addTransaction(@Valid @RequestBody Transaction transaction) throws ResourceNotFoundException {
		System.out.println("transaction obj: "+ transaction);
		return transactionservice.addTransaction(transaction);
		
	}
	
	@PostMapping("/addExternalTransaction")
	public Transaction addExternalTransaction(@Valid @RequestBody Transaction transaction) {
		System.out.println("transaction obj: "+ transaction);
		return transactionservice.addExternalTransaction(transaction);
		
	}
	
//	@PostMapping("/viewTransaction")
//	public List<Transaction> viewTransaction(@Valid @RequestBody Transaction transaction) {
//		System.out.println("transaction obj: "+ transaction);
//		return transactionRepository.findTransactions();
//	}

}
