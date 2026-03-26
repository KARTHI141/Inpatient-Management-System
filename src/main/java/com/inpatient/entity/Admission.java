package com.inpatient.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admissions")
public class Admission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer admissionId;
	private int patientId;
	private String patientName;
	private LocalDate admissionDate;
	private LocalDate dischargeDate;
	private String ward;
	private int roomNumber;
	private int bedNumber;
	private String status; // ADMITTED, DISCHARGED, TRANSFERRED

	public Admission() {}

	public Admission(int patientId, String patientName, LocalDate admissionDate, String ward,
			int roomNumber, int bedNumber, String status) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.admissionDate = admissionDate;
		this.ward = ward;
		this.roomNumber = roomNumber;
		this.bedNumber = bedNumber;
		this.status = status;
	}

	public Integer getAdmissionId() { return admissionId; }
	public void setAdmissionId(Integer admissionId) { this.admissionId = admissionId; }
	public int getPatientId() { return patientId; }
	public void setPatientId(int patientId) { this.patientId = patientId; }
	public String getPatientName() { return patientName; }
	public void setPatientName(String patientName) { this.patientName = patientName; }
	public LocalDate getAdmissionDate() { return admissionDate; }
	public void setAdmissionDate(LocalDate admissionDate) { this.admissionDate = admissionDate; }
	public LocalDate getDischargeDate() { return dischargeDate; }
	public void setDischargeDate(LocalDate dischargeDate) { this.dischargeDate = dischargeDate; }
	public String getWard() { return ward; }
	public void setWard(String ward) { this.ward = ward; }
	public int getRoomNumber() { return roomNumber; }
	public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
	public int getBedNumber() { return bedNumber; }
	public void setBedNumber(int bedNumber) { this.bedNumber = bedNumber; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
}
