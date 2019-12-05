package com.team5.project.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.Transaction;

public interface TransactionService {

	public ResponseEntity<Transaction> addTransaction(Transaction transaction) throws ResourceNotFoundException;
	
	public ResponseEntity<Transaction> addExternalTransaction(Transaction transaction) throws ResourceNotFoundException;
	
	public List<Transaction> viewTransactions(long l) throws ResourceNotFoundException;
	
	public List<Transaction> searchTransactions(Long fromAcc,String type,String mode) throws ResourceNotFoundException;
	
}
