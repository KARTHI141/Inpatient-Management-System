package com.inpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inpatient.entity.BillingRecord;

public interface BillingRepository extends JpaRepository<BillingRecord, Integer> {
	List<BillingRecord> findByPatientId(int patientId);
	List<BillingRecord> findByStatus(String status);
	List<BillingRecord> findByPatientNameContainingIgnoreCase(String keyword);
}
