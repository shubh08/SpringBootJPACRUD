package com.team5.project.service;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.team5.project.model.Transaction;

public interface TransactionService {

	public Transaction addTransaction(Transaction transaction);
	
	public Transaction addExternalTransaction(Transaction transaction);
	
}
