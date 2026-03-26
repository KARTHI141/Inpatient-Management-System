package com.inpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inpatient.entity.Admission;

public interface AdmissionRepository extends JpaRepository<Admission, Integer> {
	List<Admission> findByPatientId(int patientId);
	List<Admission> findByStatus(String status);
	List<Admission> findByPatientNameContainingIgnoreCase(String keyword);
}
