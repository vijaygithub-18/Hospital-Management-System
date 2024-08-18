package com.hospital.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This annotation defines the URL mapping for this servlet.
@WebServlet("/adminLogout")
public class AdminLogout extends HttpServlet {

	// This method handles HTTP GET requests.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Access the session.
		HttpSession session = request.getSession();

		// Remove the "adminObj" attribute from the session.
		session.removeAttribute("adminObj");

		// Set a success message in the session and redirect to the admin login page.
		session.setAttribute("succMsg", "Admin Logout Successfully");
		response.sendRedirect("admin_login.jsp");

	}

}
