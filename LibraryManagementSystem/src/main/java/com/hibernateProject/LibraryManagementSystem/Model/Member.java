package com.hibernateProject.LibraryManagementSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memeberId;
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
    @Column(nullable = false)
	private String phone;
	
	public Member(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public Member() {
		
	}

	@Override
	public String toString() {
		return "Member [memeberId=" + memeberId + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	public int getMemeberId() {
		return memeberId;
	}
	public void setMemeberId(int memeberId) {
		this.memeberId = memeberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
