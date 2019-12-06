package com.team5.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.Customer;
import com.team5.project.model.Transaction;
import com.team5.project.repository.CustomerRepository;
import com.team5.project.repository.TransactionRepository;
import com.team5.project.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<Transaction> addTransaction(Transaction transaction) throws ResourceNotFoundException {

		boolean bankTransaction = false;

		Customer fromCustomer = customerRepository.validateTransactions(transaction.getFromAccountNumber(), transaction.getStatus());
		

		Customer toCustomer = customerRepository.validateTransactions(transaction.getToAccountNumber(), transaction.getStatus());
		if (fromCustomer != null && toCustomer != null) {
			String transactionType = transaction.getTransactionType();
			String fromTransactionType = "";
			String toTransactionType = "";
			if (transactionType.equals("Debit") && transaction.getTransactionAmount() <= fromCustomer.getBalance()) {
				bankTransaction = true;
				fromCustomer.setBalance(fromCustomer.getBalance() - (int) transaction.getTransactionAmount());
				toCustomer.setBalance(toCustomer.getBalance() + (int) transaction.getTransactionAmount());
				fromTransactionType = "Debit";
				toTransactionType = "Credit";

			}

			else if (transactionType.equals("Credit")
					&& transaction.getTransactionAmount() <= toCustomer.getBalance()) {
				bankTransaction = true;
				fromCustomer.setBalance(fromCustomer.getBalance() + (int) transaction.getTransactionAmount());
				toCustomer.setBalance(toCustomer.getBalance() - (int) transaction.getTransactionAmount());
				fromTransactionType = "Credit";
				toTransactionType = "Debit";
			}

			else if ((transactionType.equals("Fees") || transactionType.equals("Checks"))
					&& transaction.getTransactionAmount() <= fromCustomer.getBalance()) {
				bankTransaction = true;
				fromCustomer.setBalance(fromCustomer.getBalance() - (int) transaction.getTransactionAmount());
				toCustomer.setBalance(toCustomer.getBalance() + (int) transaction.getTransactionAmount());
				fromTransactionType = transactionType + " - Debit";
				toTransactionType = transactionType + " - Credit";

			}

			if (bankTransaction) {
				customerRepository.save(fromCustomer);
				customerRepository.save(toCustomer);
				Transaction fromTransaction = new Transaction(transaction.getFromAccountNumber(),
						transaction.getToAccountNumber(), fromTransactionType, transaction.getTransactionAmount(),
						transaction.getAccountType(), transaction.getTransactionMode(),
						transaction.getTransactionDate(), transaction.getToBank(), transaction.getFromBank());
				Transaction toTransaction = new Transaction(transaction.getToAccountNumber(),
						transaction.getFromAccountNumber(), toTransactionType, transaction.getTransactionAmount(),
						toCustomer.getAccountType(), transaction.getTransactionMode(), transaction.getTransactionDate(),
						transaction.getToBank(), transaction.getFromBank());

				transactionRepository.save(fromTransaction);
				transactionRepository.save(toTransaction);

				return ResponseEntity.ok(fromTransaction);
			}

			else {
				throw new ResourceNotFoundException("Insufficient Amount!!");
			}
		}

		else {
			throw new ResourceNotFoundException("Accounts does not exists!!");
		}

	}

	@Override
	public ResponseEntity<Transaction> addExternalTransaction(Transaction transaction)
			throws ResourceNotFoundException {
		boolean bankTransaction = false;

		Customer fromCustomer = customerRepository.findById(transaction.getFromAccountNumber())
				.orElseThrow(() -> new ResourceNotFoundException(
						"No Customer found for this Account Number :: " + transaction.getFromAccountNumber()));

		if (fromCustomer != null) {
			String transactionType = transaction.getTransactionType();
			String fromTransactionType = "";
			if (transactionType.equals("External Payees")) {
				bankTransaction = true;
				fromCustomer.setBalance(fromCustomer.getBalance() - (int) transaction.getTransactionAmount());
				// .setBalance(toCustomer.getBalance()+(int)transaction.getTransactionAmount());
				fromTransactionType = "Debit - External Payee";

			}

			if (bankTransaction) {
				customerRepository.save(fromCustomer);
				// customerRepository.save(toCustomer);
				Transaction fromTransaction = new Transaction(transaction.getFromAccountNumber(), 0,
						fromTransactionType, transaction.getTransactionAmount(), transaction.getAccountType(),
						transaction.getTransactionMode(), transaction.getTransactionDate(), transaction.getToBank(),
						transaction.getFromBank());
				transactionRepository.save(fromTransaction);

				return ResponseEntity.ok(fromTransaction);
			}

			else {
				throw new ResourceNotFoundException("Insufficient Amount!!");
			}
		}

		else {
			throw new ResourceNotFoundException("Accounts does not exists!!");
		}
	}

	@Override
	public List<Transaction> viewTransactions(long fromAcc) throws ResourceNotFoundException {
		return transactionRepository.findTransactions(fromAcc);
	}

	@Override
	public List<Transaction> searchTransactions(Long fromAcc,String type,String mode)
			throws ResourceNotFoundException {
		return transactionRepository.searchTransactions(fromAcc,type,mode);
	}
	
	

}
