package com.team5.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team5.project.model.Customer;
import com.team5.project.model.Transaction;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
	 @Query(value="SELECT * FROM customers where account_number=:accountNumber and status=:status", nativeQuery=true)
	    public Customer validateTransactions(@Param("accountNumber") Long fromAcc,@Param("status") String status);

}
