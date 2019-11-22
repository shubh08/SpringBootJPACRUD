package com.team5.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.project.model.Transaction;
import com.team5.project.repository.TransactionRepository;
import com.team5.project.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository  transactionRepository;
	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction addExternalTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

}
