package com.team5.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team5.project.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

}
