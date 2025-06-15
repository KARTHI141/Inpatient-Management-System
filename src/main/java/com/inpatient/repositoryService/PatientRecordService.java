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
	public PatientRecordRepository patientRecordRepository;
	
	public List<PatientRecord> getAllPatientRecords() {
		return patientRecordRepository.findAll();
	}

	public void addPatientRecord(PatientRecord patientRecord) {
		patientRecordRepository.save(patientRecord);
	}

	public PatientRecord getPatientRecord(int patientRecordId) {
		return patientRecordRepository.findById(patientRecordId).orElse(new PatientRecord());
	}

	public PatientRecord setPatientRecord(PatientRecord patientRecord) {
		return patientRecordRepository.save(patientRecord);
	}

	public void deletePatientRecord(int patientRecordId) {
		patientRecordRepository.deleteById(patientRecordId);
	}

	public void load() {

		List<PatientRecord> patientRecords = new ArrayList<>(List.of(
				new PatientRecord(1, 1, 1, "Alex", "Stroke", "Thrombolysis", "Quit smoking, Get enough sleep", 1, 1),
				new PatientRecord(2, 2, 2, "Patrick", "Heart Failure", "ACE inhibitors", "Avoid Salt, Reduce fluid intake", 2, 1), 
				new PatientRecord(3, 3, 1, "Alex", "Cardiomyopathy", "Heart transplant", "Reduce Stress, Get enough sleep", 1, 2)));

		patientRecordRepository.saveAll(patientRecords);
	}

	public List<PatientRecord> search(String keyword) {
		return patientRecordRepository.findByDoctorNameContainingOrDiseaseContainingOrTreatmentContainingOrDoctorNotesContaining(keyword, keyword, keyword, keyword);
	}
}
