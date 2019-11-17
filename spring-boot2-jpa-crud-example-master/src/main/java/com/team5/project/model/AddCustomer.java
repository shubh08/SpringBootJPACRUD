package com.team5.project.model;

public class AddCustomer {
	private Long adminId;
	private String adminPass;
	private Customer cust;
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
}
