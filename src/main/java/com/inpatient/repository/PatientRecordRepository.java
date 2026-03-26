package com.inpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inpatient.entity.PatientRecord;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Integer> {
	List<PatientRecord> findByPatientId(int patientId);
	List<PatientRecord> findByDoctorNameContainingIgnoreCaseOrDiseaseContainingIgnoreCaseOrTreatmentContainingIgnoreCase(String doctorName, String disease, String treatment);
}
