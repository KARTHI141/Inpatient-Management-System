package com.inpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.inpatient.entity.Patient;

@Component
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	List<Patient> findByNameContaining(String keyword);
	
}