package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.entity.HospitalBilling;

public class HospitalBillingDAO {
	private Connection conn;

	public HospitalBillingDAO(Connection conn) {
		this.conn = conn;
	}

	// Method to get a billing record by billing ID.
	public HospitalBilling getBillingById(int billingId) {
		String query = "SELECT * FROM hospital_billing WHERE billing_id = ?";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, billingId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return extractBillingFromResultSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Method to get a list of all billing records.
	public List<HospitalBilling> getAllBillings() {
		List<HospitalBilling> billings = new ArrayList<>();
		String query = "SELECT * FROM hospital_billing";
		try (PreparedStatement statement = conn.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				billings.add(extractBillingFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billings;
	}

	// Method to add a new billing record to the database.
	public boolean addBilling(HospitalBilling billing) {
		String query = "INSERT INTO hospital_billing (patient_name, patient_id, diagnosis, treatment, total_amount, insurance_provider, insurance_coverage, amount_due) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, billing.getPatientName());
			statement.setString(2, billing.getPatientID());
			statement.setString(3, billing.getDiagnosis());
			statement.setString(4, billing.getTreatment());
			statement.setDouble(5, billing.getTotalAmount());
			statement.setString(6, billing.getInsuranceProvider());
			statement.setDouble(7, billing.getInsuranceCoverage());
			statement.setDouble(8, billing.getAmountDue());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Method to update an existing billing record in the database.
	public boolean updateBilling(HospitalBilling billing) {
		String query = "UPDATE hospital_billing SET patient_name=?, patient_id=?, diagnosis=?, treatment=?, total_amount=?, insurance_provider=?, insurance_coverage=?, amount_due=? WHERE billing_id=?";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, billing.getPatientName());
			statement.setString(2, billing.getPatientID());
			statement.setString(3, billing.getDiagnosis());
			statement.setString(4, billing.getTreatment());
			statement.setDouble(5, billing.getTotalAmount());
			statement.setString(6, billing.getInsuranceProvider());
			statement.setDouble(7, billing.getInsuranceCoverage());
			statement.setDouble(8, billing.getAmountDue());
			statement.setInt(9, billing.getBillingId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Method to delete a billing record by billing ID.
	public void deleteBilling(int billingId) {
		String query = "DELETE FROM hospital_billing WHERE billing_id = ?";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, billingId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Helper method to extract a HospitalBilling object from a ResultSet.
	private HospitalBilling extractBillingFromResultSet(ResultSet resultSet) throws SQLException {
		HospitalBilling billing = new HospitalBilling();
		billing.setBillingId(resultSet.getInt("billing_id"));
		billing.setPatientName(resultSet.getString("patient_name"));
		billing.setPatientID(resultSet.getString("patient_id"));
		billing.setDiagnosis(resultSet.getString("diagnosis"));
		billing.setTreatment(resultSet.getString("treatment"));
		billing.setTotalAmount(resultSet.getDouble("total_amount"));
		billing.setInsuranceProvider(resultSet.getString("insurance_provider"));
		billing.setInsuranceCoverage(resultSet.getDouble("insurance_coverage"));
		billing.setAmountDue(resultSet.getDouble("amount_due"));
		return billing;
	}
}
