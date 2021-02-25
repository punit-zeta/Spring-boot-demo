package com.example.spring.webservices.rest.jpa;

import javax.persistence.*;

@Entity

public class Student {

	@Id
	@GeneratedValue
	private long Id;
	private String name;
	private String role;
	
	protected Student() {
		
	}
	
	public Student(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", role=" + role + "]";
	}
	
}
