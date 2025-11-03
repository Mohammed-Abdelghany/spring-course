package com.spring.core.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Hospital {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
@Column(nullable = false)
private String name;
private Long numberOfDoctors;
private Long numberOfPatient;
@OneToMany(mappedBy ="hospital")
private List<Doctor> doctors;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
    name = "hospital_patient",
    joinColumns = @JoinColumn(name = "hospital_id"),
    inverseJoinColumns = @JoinColumn(name = "patient_id")
)
private List<Patient> patients = new ArrayList<>();

public List<Patient> getPatients() {
	return patients;
}
public void setPatients(List<Patient> patients) {
	this.patients = patients;
}
public List<Doctor> getDoctors() {
	return doctors;
}
public void setDoctors(List<Doctor> doctors) {
	this.doctors = doctors;
}

public Hospital(String name, Long numberOfDoctors, Long numberOfPatient) {
	super();
	this.name = name;
	this.numberOfDoctors = numberOfDoctors;
	this.numberOfPatient = numberOfPatient;
}
public Hospital() {
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getNumberOfDoctors() {
	return numberOfDoctors;
}
public void setNumberOfDoctors(Long numberOfDoctors) {
	this.numberOfDoctors = numberOfDoctors;
}
public Long getNumberOfPatient() {
	return numberOfPatient;
}
public void setNumberOfPatient(Long numberOfPatient) {
	this.numberOfPatient = numberOfPatient;
}


}
