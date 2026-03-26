package com.inpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inpatient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	List<Patient> findByNameContainingIgnoreCase(String keyword);
}