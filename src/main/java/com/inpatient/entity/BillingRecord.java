package com.inpatient.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing_records")
public class BillingRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billingId;
	private int patientId;
	private String patientName;
	private String description;
	private double amount;
	private LocalDate billingDate;
	private String status; // PENDING, PAID, OVERDUE
	private String paymentMethod; // CASH, CARD, INSURANCE

	public BillingRecord() {}

	public BillingRecord(int patientId, String patientName, String description, double amount,
			LocalDate billingDate, String status) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.description = description;
		this.amount = amount;
		this.billingDate = billingDate;
		this.status = status;
	}

	public Integer getBillingId() { return billingId; }
	public void setBillingId(Integer billingId) { this.billingId = billingId; }
	public int getPatientId() { return patientId; }
	public void setPatientId(int patientId) { this.patientId = patientId; }
	public String getPatientName() { return patientName; }
	public void setPatientName(String patientName) { this.patientName = patientName; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public double getAmount() { return amount; }
	public void setAmount(double amount) { this.amount = amount; }
	public LocalDate getBillingDate() { return billingDate; }
	public void setBillingDate(LocalDate billingDate) { this.billingDate = billingDate; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	public String getPaymentMethod() { return paymentMethod; }
	public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
