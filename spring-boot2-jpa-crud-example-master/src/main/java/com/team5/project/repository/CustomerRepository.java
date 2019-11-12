package com.team5.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team5.project.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
