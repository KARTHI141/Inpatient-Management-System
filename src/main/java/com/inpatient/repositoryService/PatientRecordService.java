package com.inpatient.repositoryService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inpatient.entity.PatientRecord;
import com.inpatient.repository.PatientRecordRepository;

@Service
public class PatientRecordService {

	@Autowired
	private PatientRecordRepository patientRecordRepository;

	public List<PatientRecord> getAllPatientRecords() {
		return patientRecordRepository.findAll();
	}

	public PatientRecord addPatientRecord(PatientRecord patientRecord) {
		return patientRecordRepository.save(patientRecord);
	}

	public PatientRecord getPatientRecord(int patientRecordId) {
		return patientRecordRepository.findById(patientRecordId)
				.orElseThrow(() -> new RuntimeException("Patient record not found with id: " + patientRecordId));
	}

	public PatientRecord setPatientRecord(int patientRecordId, PatientRecord patientRecord) {
		PatientRecord existing = getPatientRecord(patientRecordId);
		existing.setPatientId(patientRecord.getPatientId());
		existing.setDoctorId(patientRecord.getDoctorId());
		existing.setDoctorName(patientRecord.getDoctorName());
		existing.setDisease(patientRecord.getDisease());
		existing.setTreatment(patientRecord.getTreatment());
		existing.setDoctorNotes(patientRecord.getDoctorNotes());
		existing.setRoomNumber(patientRecord.getRoomNumber());
		existing.setBedNumber(patientRecord.getBedNumber());
		return patientRecordRepository.save(existing);
	}

	public void deletePatientRecord(int patientRecordId) {
		patientRecordRepository.deleteById(patientRecordId);
	}

	public List<PatientRecord> findByPatientId(int patientId) {
		return patientRecordRepository.findByPatientId(patientId);
	}

	public long count() {
		return patientRecordRepository.count();
	}

	public void loadSeedData() {
		if (patientRecordRepository.count() == 0) {
			List<PatientRecord> records = new ArrayList<>(List.of(
					new PatientRecord(1, 1, "Dr. Alex", "Stroke", "Thrombolysis", "Quit smoking, Get enough sleep", 101, 1),
					new PatientRecord(2, 2, "Dr. Patrick", "Heart Failure", "ACE inhibitors", "Avoid Salt, Reduce fluid intake", 102, 1),
					new PatientRecord(3, 1, "Dr. Alex", "Cardiomyopathy", "Heart transplant", "Reduce Stress, Get enough sleep", 101, 2),
					new PatientRecord(4, 3, "Dr. Sarah", "Pneumonia", "Antibiotics", "Rest, Stay hydrated", 103, 1),
					new PatientRecord(5, 4, "Dr. James", "Diabetes", "Insulin therapy", "Monitor blood sugar, Diet control", 104, 1)));
			patientRecordRepository.saveAll(records);
		}
	}

	public List<PatientRecord> search(String keyword) {
		return patientRecordRepository.findByDoctorNameContainingIgnoreCaseOrDiseaseContainingIgnoreCaseOrTreatmentContainingIgnoreCase(keyword, keyword, keyword);
	}
}
