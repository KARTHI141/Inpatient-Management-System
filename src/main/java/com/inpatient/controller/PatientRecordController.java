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

import com.inpatient.entity.PatientRecord;
import com.inpatient.repositoryService.PatientRecordService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PatientRecordController {

	@Autowired
	private PatientRecordService service;

	@GetMapping("/records")
	public List<PatientRecord> getPatientRecords() {
		return service.getAllPatientRecords();
	}

	@GetMapping("/records/{id}")
	public PatientRecord getPatientRecord(@PathVariable int id) {
		return service.getPatientRecord(id);
	}

	@PostMapping("/records")
	public PatientRecord addPatientRecord(@RequestBody PatientRecord patientRecord) {
		return service.addPatientRecord(patientRecord);
	}

	@PutMapping("/records/{id}")
	public PatientRecord updatePatientRecord(@PathVariable int id, @RequestBody PatientRecord patientRecord) {
		return service.setPatientRecord(id, patientRecord);
	}

	@DeleteMapping("/records/{id}")
	public ResponseEntity<Void> deletePatientRecord(@PathVariable int id) {
		service.deletePatientRecord(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/records/patient/{patientId}")
	public List<PatientRecord> getByPatientId(@PathVariable int patientId) {
		return service.findByPatientId(patientId);
	}

	@GetMapping("/records/search/{keyword}")
	public List<PatientRecord> searchByKeyword(@PathVariable String keyword) {
		return service.search(keyword);
	}

	@GetMapping("/records/count")
	public long count() {
		return service.count();
	}
}
