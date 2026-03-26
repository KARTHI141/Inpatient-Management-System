package com.inpatient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;

	@NotBlank(message = "Name is required")
	private String name;

	@Min(value = 0, message = "Age must be positive")
	private int age;

	private String gender;
	private String phone;
	private String address;

	public Patient() {}

	public Patient(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Patient(String name, int age, String gender, String phone, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}

	public Integer getPatientId() { return patientId; }
	public void setPatientId(Integer patientId) { this.patientId = patientId; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
}
