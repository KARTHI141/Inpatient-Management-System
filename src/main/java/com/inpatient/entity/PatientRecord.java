package com.inpatient.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class PatientRecord {

	@Id
	private int patientRecordId;
	private int patientId;
	private int doctorId;
	private String doctorName;
	private String disease;
	private String treatment;
	private String doctorNotes;

	private int roomNumber;
	private int bedNumber;

	public PatientRecord() {
	}

	public PatientRecord(int patientRecordId, int patientId, int doctorId, String doctorName, String disease,
			int roomNumber, int bedNumber) {

		this.patientRecordId = patientRecordId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.disease = disease;
		this.roomNumber = roomNumber;
		this.bedNumber = bedNumber;
	}

	public PatientRecord(int patientRecordId, int patientId, int doctorId, String doctorName, String disease,
			String treatment, String doctorNotes, int roomNumber, int bedNumber) {
		this.patientRecordId = patientRecordId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.disease = disease;
		this.treatment = treatment;
		this.doctorNotes = doctorNotes;
		this.roomNumber = roomNumber;
		this.bedNumber = bedNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}

	public int getPatientRecordId() {
		return patientRecordId;
	}

	public void setPatientRecordId(int patientRecordId) {
		this.patientRecordId = patientRecordId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getDoctorNotes() {
		return doctorNotes;
	}

	public void setDoctorNotes(String doctorNotes) {
		this.doctorNotes = doctorNotes;
	}

}
