package com.inpatient.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inpatient.repositoryService.AdmissionService;
import com.inpatient.repositoryService.BillingService;
import com.inpatient.repositoryService.PatientRecordService;
import com.inpatient.repositoryService.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DashboardController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientRecordService recordService;

	@Autowired
	private AdmissionService admissionService;

	@Autowired
	private BillingService billingService;

	@GetMapping("/dashboard")
	public Map<String, Object> getDashboardStats() {
		Map<String, Object> stats = new HashMap<>();
		stats.put("totalPatients", patientService.count());
		stats.put("totalRecords", recordService.count());
		stats.put("totalAdmissions", admissionService.count());
		stats.put("activeAdmissions", admissionService.countByStatus("ADMITTED"));
		stats.put("totalBilling", billingService.count());
		stats.put("totalRevenue", billingService.getTotalRevenue());
		stats.put("pendingAmount", billingService.getPendingAmount());
		return stats;
	}
}
