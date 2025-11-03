package com.spring.core.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Patient {
	public List<Hospital> getHospitals() {
		return hospitals;
	}
	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String typeOfDisease;
	@ManyToOne
	@JoinColumn(name="doctor_id",referencedColumnName = "id",nullable = false)
	private Doctor doctor;

    @ManyToMany(mappedBy = "patients")
    private List <Hospital> hospitals = new ArrayList<>();
	public Patient(String name, String typeOfDisease) {
		super();
		this.name = name;
		this.typeOfDisease = typeOfDisease;
	}
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
	public String getTypeOfDisease() {
		return typeOfDisease;
	}
	public void setTypeOfDisease(String typeOfDisease) {
		this.typeOfDisease = typeOfDisease;
	}

}
