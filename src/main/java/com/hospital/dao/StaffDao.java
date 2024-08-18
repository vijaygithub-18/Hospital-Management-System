package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.entity.Doctor;
import com.hospital.entity.Staff;

public class StaffDao {

	private Connection conn;

	public StaffDao(Connection conn) {
		super();
		this.conn = conn;
	}

	// Method to register a worker in the database.
	public boolean registerStaff(Staff s) {
		boolean f = false;

		try {
			String sql = "insert into staff(fname,lname,role,department,email,phone) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getFname());
			ps.setString(2, s.getLname());
			ps.setString(3, s.getRole());
			ps.setString(4, s.getDepartment());
			ps.setString(5, s.getEmail());
			ps.setString(6, s.getPhone());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// Method to retrieve a list of all workers from the database.
	public List<Staff> getAllStaff() {
		List<Staff> list = new ArrayList<Staff>();
		Staff s = null;
		try {
			String sql = "select * from staff order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Staff();
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setRole(rs.getString(4));
				s.setDepartment(rs.getString(5));
				s.setEmail(rs.getString(6));
				s.setPhone(rs.getString(7));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Method to get a worker by their ID.
	public Staff getStaffById(int id) {

		Staff s = null;
		try {
			String sql = "select * from staff where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Staff();
				s.setid(rs.getInt(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setRole(rs.getString(4));
				s.setDepartment(rs.getString(5));
				s.setEmail(rs.getString(6));
				s.setPhone(rs.getString(7));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	// Method to update worker information in the database.
	public boolean updateStaff(Staff s) {
		boolean f = false;

		try {
			String sql = "update staff set fname=?,lname=?,role=?,department=?,email=?,phone=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getFname());
			ps.setString(2, s.getLname());
			ps.setString(3, s.getRole());
			ps.setString(4, s.getDepartment());
			ps.setString(5, s.getEmail());
			ps.setString(6, s.getPhone());
			ps.setInt(7, s.getid());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// Method to delete a worker from the database.
	public boolean deleteStaff(int id) {
		boolean f = false;
		try {
			String sql = "delete from staff where id=?";
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

	// Method to count the number of workers in the database.
	public int countStaff() {
		int i = 0;
		try {
			String sql = "select * from staff";
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
