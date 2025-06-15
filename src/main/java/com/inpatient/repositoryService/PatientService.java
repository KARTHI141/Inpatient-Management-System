package com.inpatient.repositoryService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inpatient.entity.Patient;
import com.inpatient.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	public PatientRepository patientRepository;

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}

	public Patient getPatient(int patientId) {
		return patientRepository.findById(patientId).orElse(new Patient());
	}
	public Patient setPatient(int patientId, Patient patient) {
	    patient.setPatientId(patientId);
	    return patientRepository.save(patient);
	}


	public void deletePatient(int patientId) {
		patientRepository.deleteById(patientId);
	}

	public void load() {

		List<Patient> patients = new ArrayList<>(List.of(
				new Patient(1, "Shreedharma", 22, "Male", 1),
				new Patient(2, "Antony", 60, "Male", 2), 
				new Patient(3, "Tanya", 22, "Female", 3)));

		patientRepository.saveAll(patients);
	}

	public List<Patient> search(String keyword) {
		return patientRepository.findByNameContaining(keyword);
	}
}
