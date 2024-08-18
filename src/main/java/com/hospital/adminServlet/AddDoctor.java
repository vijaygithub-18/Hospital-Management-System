package com.hospital.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.DoctorDao;
import com.hospital.db.DbConnect;
import com.hospital.entity.Doctor;

//This annotation defines the URL mapping for this servlet.
@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

	// This method handles HTTP POST requests.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Extract data from the request parameters.
			String fullname = request.getParameter("fullname");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("qualification");
			String spec = request.getParameter("spec");
			String email = request.getParameter("email");
			String mobno = request.getParameter("mobno");
			String password = request.getParameter("password");

			// Create a Doctor object with the extracted data.
			Doctor d = new Doctor(fullname, dob, qualification, spec, email, mobno, password);

			// Create a DoctorDao instance with a database connection.
			DoctorDao dao = new DoctorDao(DbConnect.getConn());
			HttpSession session = request.getSession();

			// Attempt to register the doctor in the database.
			if (dao.registerDoctor(d)) {
				// If registration is successful, set a success message and redirect to a page.
				session.setAttribute("succMsg", "Doctor Added Successfully");
				response.sendRedirect("admin/doctor.jsp");
			} else {
				// If registration fails, set an error message and redirect to the same page.
				session.setAttribute("errorMsg", "Something went wrong");
				response.sendRedirect("admin/doctor.jsp");
			}
		} catch (Exception e) {
			// Handle any exceptions that may occur and print the stack trace for debugging.
			e.printStackTrace();
		}
	}

}
