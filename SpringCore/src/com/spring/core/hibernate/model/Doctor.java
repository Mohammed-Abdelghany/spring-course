package com.spring.core.hibernate.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Doctor {
public DoctorDetails getDoctorDetails() {
		return doctorDetails;
	}
	public void setDoctorDetails(DoctorDetails doctorDetails) {
		this.doctorDetails = doctorDetails;
	}
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
@Column(nullable = false)
private String username;
@Column(nullable = false)
private Double salary;
@OneToOne(cascade = CascadeType.ALL)// automatically save/update/delete details with doctor
@JoinColumn(name = "doctor_details_id",referencedColumnName = "id")
private DoctorDetails doctorDetails;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="hosbital_id",referencedColumnName="id")
private Hospital hospital;

@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
private List<Patient>patients;

public List<Patient> getPatients() {
	return patients;
}
public void setPatients(List<Patient> patients) {
	this.patients = patients;
}
public Doctor() {
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public Doctor(Long id, String username, Double salary) {
	super();
	this.id = id;
	this.username = username;
	this.salary = salary;
}
public Doctor( String username, Double salary) {
	super();
	this.username = username;
	this.salary = salary;
}
public Hospital getHospital() {
	return hospital;
}
public void setHospital(Hospital hospital) {
	this.hospital = hospital;
}
}
