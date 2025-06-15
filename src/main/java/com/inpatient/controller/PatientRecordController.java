package com.inpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inpatient.entity.PatientRecord;
import com.inpatient.repositoryService.PatientRecordService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientRecordController {
	
	@Autowired
	private PatientRecordService service;
	
	@GetMapping("/patientrecords")
	public List<PatientRecord> getPatientRecords() {
		return service.getAllPatientRecords();
	}

	@GetMapping("/patientrecord/{patientrecordId}")
	public PatientRecord getPatient(@PathVariable("patientrecordId") int patientrecordId) {
		return service.getPatientRecord(patientrecordId);
	}

	@PostMapping("/patientrecord")
	public PatientRecord addPatientRecord(@RequestBody PatientRecord patientRecord) {
		service.addPatientRecord(patientRecord);
		return service.getPatientRecord(patientRecord.getPatientRecordId());
	}

	@PutMapping("/patientrecord")
	public PatientRecord updatePatientRecord(@RequestBody PatientRecord patientRecord) {
		return service.setPatientRecord(patientRecord);
	}

	@DeleteMapping("/patientrecord/{patientRecordId}")
	public void deletePatientRecord(@PathVariable("patientRecordId") int patientRecordId) {
		service.deletePatientRecord(patientRecordId);
	}

	@GetMapping("/loadpatientrecord")
	public String loadData() {
		service.load();
		return "Success.";
	}
	
	@GetMapping("/patientrecords/keyword/{keyword}")
	public List<PatientRecord> searchByKeyword(@PathVariable("keyword") String keyword){
		return service.search(keyword);
	}
}
