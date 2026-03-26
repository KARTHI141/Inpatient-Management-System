package com.inpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inpatient.entity.Patient;
import com.inpatient.repositoryService.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PatientController {

	@Autowired
	private PatientService service;

	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return service.getAllPatients();
	}

	@GetMapping("/patients/{patientId}")
	public Patient getPatient(@PathVariable int patientId) {
		return service.getPatient(patientId);
	}

	@PostMapping("/patients")
	public Patient addPatient(@RequestBody Patient patient) {
		return service.addPatient(patient);
	}

	@PutMapping("/patients/{patientId}")
	public Patient updatePatient(@PathVariable int patientId, @RequestBody Patient patient) {
		return service.setPatient(patientId, patient);
	}

	@DeleteMapping("/patients/{patientId}")
	public ResponseEntity<Void> deletePatient(@PathVariable int patientId) {
		service.deletePatient(patientId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/patients/search/{keyword}")
	public List<Patient> searchByKeyword(@PathVariable String keyword) {
		return service.search(keyword);
	}

	@GetMapping("/patients/count")
	public long count() {
		return service.count();
	}
}
