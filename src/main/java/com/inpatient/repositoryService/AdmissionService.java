package com.inpatient.repositoryService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inpatient.entity.Admission;
import com.inpatient.repository.AdmissionRepository;

@Service
public class AdmissionService {

	@Autowired
	private AdmissionRepository admissionRepository;

	public List<Admission> getAllAdmissions() {
		return admissionRepository.findAll();
	}

	public Admission getAdmission(int admissionId) {
		return admissionRepository.findById(admissionId)
				.orElseThrow(() -> new RuntimeException("Admission not found with id: " + admissionId));
	}

	public Admission addAdmission(Admission admission) {
		return admissionRepository.save(admission);
	}

	public Admission updateAdmission(int admissionId, Admission admission) {
		Admission existing = getAdmission(admissionId);
		existing.setPatientId(admission.getPatientId());
		existing.setPatientName(admission.getPatientName());
		existing.setAdmissionDate(admission.getAdmissionDate());
		existing.setDischargeDate(admission.getDischargeDate());
		existing.setWard(admission.getWard());
		existing.setRoomNumber(admission.getRoomNumber());
		existing.setBedNumber(admission.getBedNumber());
		existing.setStatus(admission.getStatus());
		return admissionRepository.save(existing);
	}

	public Admission dischargePatient(int admissionId) {
		Admission existing = getAdmission(admissionId);
		existing.setStatus("DISCHARGED");
		existing.setDischargeDate(LocalDate.now());
		return admissionRepository.save(existing);
	}

	public void deleteAdmission(int admissionId) {
		admissionRepository.deleteById(admissionId);
	}

	public List<Admission> findByPatientId(int patientId) {
		return admissionRepository.findByPatientId(patientId);
	}

	public List<Admission> findByStatus(String status) {
		return admissionRepository.findByStatus(status);
	}

	public long count() {
		return admissionRepository.count();
	}

	public long countByStatus(String status) {
		return admissionRepository.findByStatus(status).size();
	}

	public List<Admission> search(String keyword) {
		return admissionRepository.findByPatientNameContainingIgnoreCase(keyword);
	}

	public void loadSeedData() {
		if (admissionRepository.count() == 0) {
			List<Admission> admissions = new ArrayList<>(List.of(
					new Admission(1, "Shreedharma", LocalDate.of(2024, 1, 15), "Cardiology", 101, 1, "ADMITTED"),
					new Admission(2, "Antony", LocalDate.of(2024, 1, 10), "Cardiology", 102, 1, "ADMITTED"),
					new Admission(3, "Tanya", LocalDate.of(2024, 1, 5), "Pulmonology", 103, 1, "DISCHARGED"),
					new Admission(4, "Rajesh Kumar", LocalDate.of(2024, 2, 1), "Endocrinology", 104, 1, "ADMITTED")));
			admissions.get(2).setDischargeDate(LocalDate.of(2024, 1, 12));
			admissionRepository.saveAll(admissions);
		}
	}
}
