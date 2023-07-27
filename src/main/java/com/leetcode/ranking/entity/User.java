package com.leetcode.ranking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String name;
	private String email;
	private String institute;
	private String country;
	private String lusername;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String institute, String country, String lusername) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.institute = institute;
		this.country = country;
		this.lusername = lusername;
	}
	public int getId() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLusername() {
		return lusername;
	}
	public void setLusername(String lusername) {
		this.lusername = lusername;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", institute=" + institute + ", country="
				+ country + ", lusername=" + lusername + "]";
	}
}
