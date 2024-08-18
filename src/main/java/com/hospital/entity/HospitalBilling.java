package com.hospital.entity;

import java.util.Date;

public class HospitalBilling {
	private int billingId; // Unique billing identifier
	private String patientName; // Name of the patient
	private String patientID; // Patient's unique ID
	private String diagnosis; // Medical diagnosis
	private String treatment; // Treatment administered
	private double totalAmount; // Total billing amount
	private String insuranceProvider; // Name of the patient's insurance provider, if applicable
	private double insuranceCoverage; // Amount covered by insurance
	private double amountDue; // Remaining amount due after insurance coverage

	public HospitalBilling() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HospitalBilling(int billingId, String patientName, String patientID, String diagnosis, String treatment,
			double totalAmount, String insuranceProvider, double insuranceCoverage, double amountDue) {
		super();
		this.billingId = billingId;
		this.patientName = patientName;
		this.patientID = patientID;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.totalAmount = totalAmount;
		this.insuranceProvider = insuranceProvider;
		this.insuranceCoverage = insuranceCoverage;
		this.amountDue = amountDue;
	}

	public int getBillingId() {
		return billingId;
	}

	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public double getInsuranceCoverage() {
		return insuranceCoverage;
	}

	public void setInsuranceCoverage(double insuranceCoverage) {
		this.insuranceCoverage = insuranceCoverage;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

}
