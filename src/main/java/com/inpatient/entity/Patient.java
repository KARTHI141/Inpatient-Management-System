package com.inpatient.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Patient {
	@Id
	private int patientId;
	private String name;
	private int age;
	private String gender;
	private int patientRecordId;
	
	public Patient() {
		
	}
	
	public Patient(int patientId, String name) {
		this.patientId = patientId;
		this.name = name;
	}

	public Patient(int patientId, String name, int age, String gender) {

		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Patient(int patientId, String name, int age, String gender, int patientRecordId) {
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.patientRecordId = patientRecordId;
	}

	public int getPatientRecordId() {
		return patientRecordId;
	}

	public void setPatientRecord(int patientRecordId) {
		this.patientRecordId = patientRecordId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
