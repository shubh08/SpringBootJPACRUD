package com.team5.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "transaction")
public class Transaction {

	private long tid;
	private long fromAccountNumber;
	private long toAccountNumber;
	private String transactionType;
	private double transactionAmount;
	private String accountType;
	private String transactionMode;
	private String transactionDate;
	private String toBank;
	private String fromBank;
	
	
	
	
	public String getTransactionType() {
		return transactionType;
	}



	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}



	public String getToBank() {
		return toBank;
	}



	public void setToBank(String toBank) {
		this.toBank = toBank;
	}



	public String getFromBank() {
		return fromBank;
	}



	public void setFromBank(String fromBank) {
		this.fromBank = fromBank;
	}



	public Transaction(long tid, long fromAccountNumber, long toAccountNumber, String transactionType,
			double transactionAmount, String accountType, String transactionMode, String transactionDate, String toBank,
			String fromBank) {
		super();
		this.tid = tid;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.accountType = accountType;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.toBank = toBank;
		this.fromBank = fromBank;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getTid() {
		return tid;
	}



	public void setTid(long tid) {
		this.tid = tid;
	}


	@Column(name = "fromAccountNumber", nullable = false)
	public long getFromAccountNumber() {
		return fromAccountNumber;
	}



	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}


	@Column(name = "toAccountNumber", nullable = false)
	public long getToAccountNumber() {
		return toAccountNumber;
	}



	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}


	@Column(name = "transactionAmount", nullable = false)
	public double getTransactionAmount() {
		return transactionAmount;
	}



	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	@Column(name = "transactionMode", nullable = false)
	public String getTransactionMode() {
		return transactionMode;
	}



	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	@Column(name = "transactionDate", nullable = false)
	public String getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}



	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", fromAccountNumber=" + fromAccountNumber + ", toAccountNumber="
				+ toAccountNumber + ", transactionType=" + transactionType + ", transactionAmount=" + transactionAmount
				+ ", accountType=" + accountType + ", transactionMode=" + transactionMode + ", transactionDate="
				+ transactionDate + ", toBank=" + toBank + ", fromBank=" + fromBank + "]";
	}


	
	
}
