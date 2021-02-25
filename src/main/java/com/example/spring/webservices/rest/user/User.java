package com.example.spring.webservices.rest.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/*
 * POJO for user data
 */
public class User {

	private Integer id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	@Past
	private Date dob;
	
	
	protected User() {
		
	}
	
	public User(String name) {
		super();
		this.name = name;
		this.dob = new Date();
	}
	
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
}
