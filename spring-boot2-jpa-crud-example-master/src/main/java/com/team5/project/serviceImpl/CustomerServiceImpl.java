package com.team5.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.AddCustomer;
import com.team5.project.model.Admin;
import com.team5.project.model.Customer;
import com.team5.project.repository.AdminRepository;
import com.team5.project.repository.CustomerRepository;
import com.team5.project.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Customer addAccount(AddCustomer addCust) throws ResourceNotFoundException {
		Long adminId = addCust.getAdminId();
		String adminPass = addCust.getAdminPassword();
		Customer customer = addCust.getCust();
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("No Admin found for this AdminID  :: " + adminId));
		
		if(admin.getAdminPassword().equals(adminPass)) {
			System.out.println("customer obj: "+ customer);		
			return customerRepository.save(customer);
		}else {
			System.out.println("ADMIN CREDENTIALS MISMATCH");
			throw new ResourceNotFoundException(adminPass); 
		}
		
	}

	@Override
	public ResponseEntity<Customer> closeCustomerAccount(AddCustomer customerObj) throws ResourceNotFoundException {
		Long accountNumber = customerObj.getCust().getAccountNumber();
		System.out.println("Account number: "+accountNumber);
		System.out.println("Cust Obj: "+customerObj);
		
		Long adminId = customerObj.getAdminId();
		String adminPass = customerObj.getAdminPassword();
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("No Admin found for this AdminID  :: " + adminId));
		
		if(admin.getAdminPassword().equals(adminPass)) {	
			Customer customer = customerRepository.findById(accountNumber)
					.orElseThrow(() -> new ResourceNotFoundException("No Customer found for this Account Number :: " + accountNumber));

			customer.setStatus("Inactive");
			
			final Customer closedCustomerAccount = customerRepository.save(customer);
			return ResponseEntity.ok(closedCustomerAccount);
		}else {
			System.out.println("ADMIN CREDENTIALS MISMATCH");
			throw new ResourceNotFoundException("ADMIN CREDENTIALS MISMATCH"); 
		}
		
		
		
	
	}


	
}
