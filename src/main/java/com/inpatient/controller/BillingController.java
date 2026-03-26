package com.inpatient.controller;

import java.util.List;
import java.util.Map;

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

import com.inpatient.entity.BillingRecord;
import com.inpatient.repositoryService.BillingService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BillingController {

	@Autowired
	private BillingService service;

	@GetMapping("/billing")
	public List<BillingRecord> getAllBillingRecords() {
		return service.getAllBillingRecords();
	}

	@GetMapping("/billing/{id}")
	public BillingRecord getBillingRecord(@PathVariable int id) {
		return service.getBillingRecord(id);
	}

	@PostMapping("/billing")
	public BillingRecord addBillingRecord(@RequestBody BillingRecord billingRecord) {
		return service.addBillingRecord(billingRecord);
	}

	@PutMapping("/billing/{id}")
	public BillingRecord updateBillingRecord(@PathVariable int id, @RequestBody BillingRecord billingRecord) {
		return service.updateBillingRecord(id, billingRecord);
	}

	@PutMapping("/billing/{id}/pay")
	public BillingRecord markAsPaid(@PathVariable int id, @RequestBody Map<String, String> body) {
		String paymentMethod = body.getOrDefault("paymentMethod", "CASH");
		return service.markAsPaid(id, paymentMethod);
	}

	@DeleteMapping("/billing/{id}")
	public ResponseEntity<Void> deleteBillingRecord(@PathVariable int id) {
		service.deleteBillingRecord(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/billing/patient/{patientId}")
	public List<BillingRecord> getByPatientId(@PathVariable int patientId) {
		return service.findByPatientId(patientId);
	}

	@GetMapping("/billing/status/{status}")
	public List<BillingRecord> getByStatus(@PathVariable String status) {
		return service.findByStatus(status);
	}

	@GetMapping("/billing/search/{keyword}")
	public List<BillingRecord> searchByKeyword(@PathVariable String keyword) {
		return service.search(keyword);
	}

	@GetMapping("/billing/count")
	public long count() {
		return service.count();
	}

	@GetMapping("/billing/revenue")
	public double getTotalRevenue() {
		return service.getTotalRevenue();
	}

	@GetMapping("/billing/pending")
	public double getPendingAmount() {
		return service.getPendingAmount();
	}
}
