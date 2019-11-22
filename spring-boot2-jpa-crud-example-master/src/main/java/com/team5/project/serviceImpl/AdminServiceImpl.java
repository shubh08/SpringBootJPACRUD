package com.team5.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.project.model.Admin;
import com.team5.project.repository.AdminRepository;
import com.team5.project.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin addAccount(Admin admin) {
		 return adminRepository.save(admin);
	}

}
