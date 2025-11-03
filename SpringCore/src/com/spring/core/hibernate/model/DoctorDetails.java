package com.spring.core.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DoctorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String fukkAddress;
	@Column(nullable = false)
	private String fisrtName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private int age;

	@OneToOne(mappedBy = "doctorDetails")
	private Doctor doctor;

	public DoctorDetails() {
		// TODO Auto-generated constructor stub
	}
	public DoctorDetails(String fukkAddress, String fisrtName, String lastName, int age) {
		super();
		this.fukkAddress = fukkAddress;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFukkAddress() {
		return fukkAddress;
	}
	public void setFukkAddress(String fukkAddress) {
		this.fukkAddress = fukkAddress;
	}
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
