package com.hospital.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.SpecialistDao;
import com.hospital.db.DbConnect;
import com.hospital.entity.Patient;

// This annotation defines the URL mapping for this servlet.
@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {

	// This method handles HTTP POST requests.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Extract the specialist name from the request parameters.
		String specName = request.getParameter("specName");

		// Create a SpecialistDao instance with a database connection.
		SpecialistDao dao = new SpecialistDao(DbConnect.getConn());

		// Attempt to add a specialist with the provided name to the database.
		boolean f = dao.addSpecialist(specName);

		HttpSession session = request.getSession();

		if (f) {
			// If adding the specialist is successful, set a success message and redirect to
			// the admin page.
			session.setAttribute("succMsg", "Specialist Added");
			response.sendRedirect("admin/admin.jsp");
		} else {
			// If adding the specialist fails, set an error message and redirect to the
			// admin login page.
			session.setAttribute("errorMsg", "Something went wrong");
			response.sendRedirect("admin_login.jsp");
		}
	}

}
