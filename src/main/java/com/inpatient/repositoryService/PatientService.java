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
	private PatientRepository patientRepository;

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public Patient getPatient(int patientId) {
		return patientRepository.findById(patientId)
				.orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));
	}

	public Patient setPatient(int patientId, Patient patient) {
		Patient existing = getPatient(patientId);
		existing.setName(patient.getName());
		existing.setAge(patient.getAge());
		existing.setGender(patient.getGender());
		existing.setPhone(patient.getPhone());
		existing.setAddress(patient.getAddress());
		return patientRepository.save(existing);
	}

	public void deletePatient(int patientId) {
		patientRepository.deleteById(patientId);
	}

	public long count() {
		return patientRepository.count();
	}

	public void loadSeedData() {
		if (patientRepository.count() == 0) {
			List<Patient> patients = new ArrayList<>(List.of(
					new Patient("Shreedharma", 22, "Male", "9876543210", "Chennai, India"),
					new Patient("Antony", 60, "Male", "9876543211", "Mumbai, India"),
					new Patient("Tanya", 22, "Female", "9876543212", "Delhi, India"),
					new Patient("Rajesh Kumar", 45, "Male", "9876543213", "Bangalore, India"),
					new Patient("Priya Sharma", 35, "Female", "9876543214", "Hyderabad, India")));
			patientRepository.saveAll(patients);
		}
	}

	public List<Patient> search(String keyword) {
		return patientRepository.findByNameContainingIgnoreCase(keyword);
	}
}
