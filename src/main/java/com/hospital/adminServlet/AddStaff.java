package com.hospital.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.DoctorDao;
import com.hospital.dao.StaffDao;
import com.hospital.db.DbConnect;
import com.hospital.entity.Doctor;
import com.hospital.entity.Staff;

@WebServlet("/addStaff")
public class AddStaff extends HttpServlet {

	private int i;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Extract data from request parameters.
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String role = request.getParameter("role");
			String department = request.getParameter("department");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");

			// Create a Worker object.
			Staff s = new Staff();

			// Create a StaffDao instance with a database connection.
			StaffDao dao = new StaffDao(DbConnect.getConn());
			HttpSession session = request.getSession();

			// Attempt to register the worker in the database.
			if (dao.registerStaff(s)) {
				// If registration is successful, set a success message and redirect to a page.
				session.setAttribute("succMsg", "Worker Added Successfully");
				response.sendRedirect("admin/staff.jsp");
			} else {
				// If registration fails, set an error message and redirect to the same page.
				session.setAttribute("errorMsg", "Something went wrong");
				response.sendRedirect("admin/staff.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
