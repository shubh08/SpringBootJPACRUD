package com.team5.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	private long adminId;
	private String name;
	private String email;
	private String phone;
	private String adminPassword;
	private String bankName;
	private String status;

	public Admin(String name, String email, String phone, String adminPassword, String bankName,String status) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.adminPassword = adminPassword;
		this.bankName = bankName;
		this.status = status;
	}
	
	public Admin() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}


	@Column(name = "bankName", nullable = false)
	public String getBankName() {
		return bankName;
	}




	@Column(name = "adminPassword", nullable = false)
	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", adminPassword="
				+ adminPassword + ", bankName=" + bankName + "]";
	}

}
