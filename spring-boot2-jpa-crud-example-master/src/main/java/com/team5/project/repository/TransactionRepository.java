package com.team5.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team5.project.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	
//	SELECT c, l FROM Country c JOIN c.languages l
//	WHERE c.population > :p AND l in :languages
//	  @Query("SELECT t FROM Transaction t where STR_TO_DATE(transaction_date, \"%m-%d-%Y\") > DATE_SUB(now(), INTERVAL 18 MONTH) ")
//	    public List<Transaction> findTransactions();
}
