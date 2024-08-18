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

//This annotation defines the URL mapping for this servlet.
@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

	// This method handles HTTP GET requests.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Extract the ID of the doctor to be deleted from the request parameter.
		int id = Integer.parseInt(request.getParameter("id"));

		// Create a DoctorDao instance with a database connection.
		DoctorDao dao = new DoctorDao(DbConnect.getConn());
		HttpSession session = request.getSession();

		// Attempt to delete the doctor with the specified ID.
		if (dao.deleteDoctor(id)) {
			// If deletion is successful, set a success message and redirect to the view
			// doctor page.
			session.setAttribute("succMsg", "Doctor Delete Successfully");
			response.sendRedirect("admin/view_doctor.jsp");
		} else {
			// If deletion fails, set an error message and redirect to the view doctor page.
			session.setAttribute("errorMsg", "Something went wrong");
			response.sendRedirect("admin/view_doctor.jsp");
		}
	}

}
