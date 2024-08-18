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
@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet {

	// This method handles HTTP POST requests.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// Extract data from request parameters.
			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");
			String password = req.getParameter("password");

			// Extract the ID of the doctor to be updated from the request parameter.
			int id = Integer.parseInt(req.getParameter("id"));

			// Create a Doctor object with the updated data.
			Doctor d = new Doctor(id, fullName, dob, qualification, spec, email, mobno, password);

			// Create a DoctorDao instance with a database connection.
			DoctorDao dao = new DoctorDao(DbConnect.getConn());
			HttpSession session = req.getSession();

			// Attempt to update the doctor's information in the database.
			if (dao.updateDoctor(d)) {
				// If the update is successful, set a success message and redirect to the view
				// doctor page.
				session.setAttribute("succMsg", "Doctor Update Sucessfully..");
				resp.sendRedirect("admin/view_doctor.jsp");
			} else {
				// If the update fails, set an error message and redirect to the view doctor
				// page.
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/view_doctor.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
