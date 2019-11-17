package com.team5.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.project.model.Transaction;
import com.team5.project.repository.TransactionRepository;


@RestController
@RequestMapping("customer")
public class TransactionController {
	

@Autowired
TransactionRepository transactionRepository;
	
	@PostMapping("/addTransaction")
	public Transaction addTransaction(@Valid @RequestBody Transaction transaction) {
		System.out.println("transaction obj: "+ transaction);
		return transactionRepository.save(transaction);
	}

}
