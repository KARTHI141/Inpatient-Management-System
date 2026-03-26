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

import com.inpatient.entity.Admission;
import com.inpatient.repositoryService.AdmissionService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AdmissionController {

	@Autowired
	private AdmissionService service;

	@GetMapping("/admissions")
	public List<Admission> getAllAdmissions() {
		return service.getAllAdmissions();
	}

	@GetMapping("/admissions/{id}")
	public Admission getAdmission(@PathVariable int id) {
		return service.getAdmission(id);
	}

	@PostMapping("/admissions")
	public Admission addAdmission(@RequestBody Admission admission) {
		return service.addAdmission(admission);
	}

	@PutMapping("/admissions/{id}")
	public Admission updateAdmission(@PathVariable int id, @RequestBody Admission admission) {
		return service.updateAdmission(id, admission);
	}

	@PutMapping("/admissions/{id}/discharge")
	public Admission dischargePatient(@PathVariable int id) {
		return service.dischargePatient(id);
	}

	@DeleteMapping("/admissions/{id}")
	public ResponseEntity<Void> deleteAdmission(@PathVariable int id) {
		service.deleteAdmission(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/admissions/patient/{patientId}")
	public List<Admission> getByPatientId(@PathVariable int patientId) {
		return service.findByPatientId(patientId);
	}

	@GetMapping("/admissions/status/{status}")
	public List<Admission> getByStatus(@PathVariable String status) {
		return service.findByStatus(status);
	}

	@GetMapping("/admissions/search/{keyword}")
	public List<Admission> searchByKeyword(@PathVariable String keyword) {
		return service.search(keyword);
	}

	@GetMapping("/admissions/count")
	public long count() {
		return service.count();
	}
}
