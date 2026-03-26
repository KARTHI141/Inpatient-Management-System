package com.inpatient.repositoryService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inpatient.entity.BillingRecord;
import com.inpatient.repository.BillingRepository;

@Service
public class BillingService {

	@Autowired
	private BillingRepository billingRepository;

	public List<BillingRecord> getAllBillingRecords() {
		return billingRepository.findAll();
	}

	public BillingRecord getBillingRecord(int billingId) {
		return billingRepository.findById(billingId)
				.orElseThrow(() -> new RuntimeException("Billing record not found with id: " + billingId));
	}

	public BillingRecord addBillingRecord(BillingRecord billingRecord) {
		return billingRepository.save(billingRecord);
	}

	public BillingRecord updateBillingRecord(int billingId, BillingRecord billingRecord) {
		BillingRecord existing = getBillingRecord(billingId);
		existing.setPatientId(billingRecord.getPatientId());
		existing.setPatientName(billingRecord.getPatientName());
		existing.setDescription(billingRecord.getDescription());
		existing.setAmount(billingRecord.getAmount());
		existing.setBillingDate(billingRecord.getBillingDate());
		existing.setStatus(billingRecord.getStatus());
		existing.setPaymentMethod(billingRecord.getPaymentMethod());
		return billingRepository.save(existing);
	}

	public BillingRecord markAsPaid(int billingId, String paymentMethod) {
		BillingRecord existing = getBillingRecord(billingId);
		existing.setStatus("PAID");
		existing.setPaymentMethod(paymentMethod);
		return billingRepository.save(existing);
	}

	public void deleteBillingRecord(int billingId) {
		billingRepository.deleteById(billingId);
	}

	public List<BillingRecord> findByPatientId(int patientId) {
		return billingRepository.findByPatientId(patientId);
	}

	public List<BillingRecord> findByStatus(String status) {
		return billingRepository.findByStatus(status);
	}

	public long count() {
		return billingRepository.count();
	}

	public double getTotalRevenue() {
		return billingRepository.findByStatus("PAID").stream()
				.mapToDouble(BillingRecord::getAmount).sum();
	}

	public double getPendingAmount() {
		return billingRepository.findByStatus("PENDING").stream()
				.mapToDouble(BillingRecord::getAmount).sum();
	}

	public List<BillingRecord> search(String keyword) {
		return billingRepository.findByPatientNameContainingIgnoreCase(keyword);
	}

	public void loadSeedData() {
		if (billingRepository.count() == 0) {
			List<BillingRecord> records = new ArrayList<>(List.of(
					new BillingRecord(1, "Shreedharma", "Cardiology Consultation", 5000.00, LocalDate.of(2024, 1, 15), "PAID"),
					new BillingRecord(1, "Shreedharma", "Room Charges (5 days)", 25000.00, LocalDate.of(2024, 1, 20), "PENDING"),
					new BillingRecord(2, "Antony", "Heart Surgery", 150000.00, LocalDate.of(2024, 1, 12), "PAID"),
					new BillingRecord(3, "Tanya", "Pulmonology Treatment", 8000.00, LocalDate.of(2024, 1, 8), "PAID"),
					new BillingRecord(4, "Rajesh Kumar", "Diabetes Treatment", 3000.00, LocalDate.of(2024, 2, 1), "PENDING")));
			records.get(0).setPaymentMethod("CARD");
			records.get(2).setPaymentMethod("INSURANCE");
			records.get(3).setPaymentMethod("CASH");
			billingRepository.saveAll(records);
		}
	}
}
