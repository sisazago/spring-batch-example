package com.sisaza.spring.batch.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.sisaza.spring.batch.example.domain.abstracts.Entities;

@Entity
public class Person extends Entities implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 30)
	private String firstName;
	
	@Column(nullable = false, length = 30)
	private String lastName;
	
	@Column(nullable = false, length = 15)
	private String phone;
	
	@Column(nullable = false, length = 180)
	private String email;

	@Override
	public Person withId(Long id) {
		super.setId(id);
		return this;
	}

	@Override
	public Person withEnabled(boolean enabled) {
		super.setEnabled(enabled);
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPerson(String firstName, String lastName, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}

}
