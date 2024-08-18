package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hospital.entity.Patient;

public class PatientDao {

	private Connection conn;

	public PatientDao(Connection conn) {
		super();
		this.conn = conn;
	}

	// Method to register a new patient.
	public boolean PatientRegister(Patient p) {
		boolean f = false;

		try {
			String sql = "insert into patient(fullname,email,password) values(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getfullname());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getPassword());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// Method to authenticate a patient based on email and password.
	public Patient login(String em, String psw) {

		Patient p = null;

		try {
			String sql = "select * from patient where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Patient();
				p.setId(rs.getInt(1));
				p.setfullname(rs.getString(2));
				p.setEmail(rs.getString(3));
				p.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	// Method to check the old password of a patient.
	public boolean checkOldPassword(int userId, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from patient where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	// Method to change the password of a patient.
	public boolean changePassword(int userId, String newPassword) {
		boolean f = false;

		try {
			String sql = "update patient set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newPassword);
			ps.setInt(2, userId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public int countPatient() {
		int i = 0;
		try {
			String sql = "select * from patient";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}
}
