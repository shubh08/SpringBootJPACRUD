package com.team5.project.serviceImpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team5.project.exception.ResourceNotFoundException;
import com.team5.project.model.AddCustomer;
import com.team5.project.model.Admin;
import com.team5.project.model.Customer;
import com.team5.project.model.Transaction;
import com.team5.project.repository.AdminRepository;
import com.team5.project.repository.CustomerRepository;
import com.team5.project.repository.TransactionRepository;
import com.team5.project.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Admin addAccount(Admin admin) {
		 return adminRepository.save(admin);
	}

	@Override
	public ResponseEntity<Transaction> addRefunds(@Valid AddCustomer manual) throws ResourceNotFoundException {
		Long adminId = manual.getAdminId();
		String adminPass = manual.getAdminPassword();
		Customer customer = manual.getCust();
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("No Admin found for this AdminID  :: " + adminId));
		
		if(admin.getAdminPassword().equals(adminPass)) {
			System.out.println("customer obj: "+ customer);		
			Customer fromCustomer = customerRepository.findById(customer.getAccountNumber())
					.orElseThrow(() -> new ResourceNotFoundException("No Customer found for this Account Number :: " + customer.getAccountNumber()));
			fromCustomer.setBalance(fromCustomer.getBalance()+customer.getBalance());
			customerRepository.save(fromCustomer);
			Transaction transaction = new Transaction(customer.getAccountNumber(), 0, "Credit-ManualRefund", customer.getBalance(), customer.getAccountType(), "One-Time",java.time.LocalDate.now().toString(), customer.getBank(),customer.getBank());
			transactionRepository.save(transaction);
			return ResponseEntity.ok(transaction);
			
		}else {
			System.out.println("ADMIN CREDENTIALS MISMATCH");
			throw new ResourceNotFoundException(adminPass); 
		}
	}

}
