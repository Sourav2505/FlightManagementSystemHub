package com.cg.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="flight_user")
public class User {
	@Id
	@Column(name="contact_no")
	private String contactNo;

	@Column(name="user_name", length=25)
	private String userName;
	
	@Column(name="password", length=25)
	private String password;
	
	@Column(name="address", length=25)
	private String address;
	
	@Column(name="city", length=25)
	private String city;
	
	@Column(name="role")
	private String role;
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String contactNo, String userName, String password, String address, String city, String role) {
		super();
		this.contactNo = contactNo;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.city = city;
		this.role = role;
	}
	public User() {
		super();
	}
		
}
