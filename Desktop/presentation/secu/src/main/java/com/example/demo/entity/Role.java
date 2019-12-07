package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Role implements Serializable{
@Id
	private String role ;
	private String descreption ;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public Role(String role, String descreption) {
		super();
		this.role = role;
		this.descreption = descreption;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
