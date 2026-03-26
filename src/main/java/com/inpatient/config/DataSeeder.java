package com.inpatient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.inpatient.repositoryService.AdmissionService;
import com.inpatient.repositoryService.BillingService;
import com.inpatient.repositoryService.PatientRecordService;
import com.inpatient.repositoryService.PatientService;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientRecordService patientRecordService;

	@Autowired
	private AdmissionService admissionService;

	@Autowired
	private BillingService billingService;

	@Override
	public void run(String... args) {
		patientService.loadSeedData();
		patientRecordService.loadSeedData();
		admissionService.loadSeedData();
		billingService.loadSeedData();
	}
}
