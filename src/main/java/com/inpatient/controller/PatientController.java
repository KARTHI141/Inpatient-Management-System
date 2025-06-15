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
	
	import com.inpatient.entity.Patient;
	import com.inpatient.repositoryService.PatientService;
	
	@RestController
	@CrossOrigin(origins = "http://localhost:4200")
	
	public class PatientController {
	
		@Autowired
		private PatientService service;
	
		@GetMapping("/patients")
		public List<Patient> getPatients() {
			return service.getAllPatients();
		}
	
		@GetMapping("/patient/{patientId}")
		public Patient getPatient(@PathVariable("patientId") int patientId) {
			return service.getPatient(patientId);
		}
	
		@PostMapping("/patient")
		public Patient addPatient(@RequestBody Patient patient) {
			service.addPatient(patient);
			return service.getPatient(patient.getPatientId());
		}
	
		@PutMapping("/patient/{patientId}")
		public Patient updatePatient(@PathVariable int patientId, @RequestBody Patient patient) {
		    return service.setPatient(patientId, patient);
		}
	
	
		@DeleteMapping("/patient/{patientId}")
		public void deletePatient(@PathVariable("patientId") int patientId) {
			service.deletePatient(patientId);
		}
	
		@GetMapping("/loadpatient")
		public String loadData() {
			service.load();
			return "Success.";
		}
		
		@GetMapping("/patients/keyword/{keyword}")
		public List<Patient> searchByKeyword(@PathVariable("keyword") String keyword){
			return service.search(keyword);
		}
	
	}
