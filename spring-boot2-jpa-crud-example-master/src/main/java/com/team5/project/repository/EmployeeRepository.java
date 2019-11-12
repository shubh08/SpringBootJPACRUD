package com.team5.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team5.project.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
