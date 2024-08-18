package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.entity.Doctor;

public class DoctorDao {

	private Connection conn;

	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
	}

	// Method to register a new doctor in the database.
	public boolean registerDoctor(Doctor d) {
		boolean f = false;

		try {
			// SQL query to insert doctor data into the database.
			String sql = "insert into doctor(full_name,dob,qualification,specialist,email,mobNo,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// Method to get a list of all doctors in the database.
	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {
			// SQL query to select all doctors, ordered by ID in descending order.
			String sql = "select * from doctor order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Method to get a doctor by their ID.
	public Doctor getDoctorById(int id) {

		Doctor d = null;
		try {
			// SQL query to select a doctor by ID.
			String sql = "select * from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	// Method to update a doctor's information in the database.
	public boolean updateDoctor(Doctor d) {
		boolean f = false;

		try {
			// SQL query to update a doctor's information by their ID.
			String sql = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// Method to delete a doctor from the database by their ID.
	public boolean deleteDoctor(int id) {
		boolean f = false;
		try {
			// SQL query to delete a doctor by their ID.
			String sql = "delete from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// Method to authenticate a doctor by their email and password.
	public Doctor login(String email, String psw) {
		Doctor d = null;
		try {
			// SQL query to authenticate a doctor by email and password.
			String sql = "select * from doctor where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	// Method to count the total number of doctors in the database.
	public int countDoctor() {
		int i = 0;
		try {
			// SQL query to count the total number of doctors.
			String sql = "select * from doctor";
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

	// Method to count the total number of appointments in the database.
	public int countAppointment() {
		int i = 0;
		try {
			// SQL query to count the total number of appointments.
			String sql = "select * from appointment";
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

	// Method to count the total number of appointments for a specific doctor based
	// on their ID.
	public int countAppointmentByDoctorId(int did) {
		int i = 0;
		try {
			// SQL query to count the total number of appointments for a specific doctor.
			String sql = "select * from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	// Method to count the total number of users in the database.
	public int countUser() {
		int i = 0;
		try {
			// SQL query to count the total number of users.
			String sql = "select * from user_dtls";
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

	// Method to count the total number of specialist doctors in the database.
	public int countSpecialist() {
		int i = 0;
		try {
			// SQL query to count the total number of specialist doctors.
			String sql = "select * from specialist";
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

	// Method to check if the old password provided by a doctor is correct.
	public boolean checkOldPassword(int userId, String oldPassword) {
		boolean f = false;

		try {
			// SQL query to check the old password of a doctor.
			String sql = "select * from doctor where id=? and password=?";
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

	// Method to change a doctor's password in the database.
	public boolean changePassword(int userId, String newPassword) {
		boolean f = false;

		try {
			// SQL query to change a doctor's password.
			String sql = "update doctor set password=? where id=?";
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

	// Method to edit a doctor's profile information in the database.
	public boolean editDoctorProfile(Doctor d) {
		boolean f = false;

		try {
			// SQL query to update a doctor's profile information.
			String sql = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setInt(7, d.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
