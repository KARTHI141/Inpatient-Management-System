package com.inpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.inpatient.entity.PatientRecord;

@Component
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Integer> {
	
	List<PatientRecord> findByDoctorNameContainingOrDiseaseContainingOrTreatmentContainingOrDoctorNotesContaining(String doctorName, String disease, String treatment, String doctorNotes);
	
}
