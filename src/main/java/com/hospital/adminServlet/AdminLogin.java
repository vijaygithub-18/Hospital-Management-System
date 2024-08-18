package com.hospital.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entity.Patient;

//This annotation defines the URL mapping for this servlet.
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {

	// This method handles HTTP POST requests.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Extract email and password from request parameters.
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			HttpSession session = request.getSession();

			// Check if the provided email and password match the admin credentials.
			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
				// If the credentials are correct, set an admin object in the session and
				// redirect to the admin index page.
				session.setAttribute("adminObj", new Patient());
				response.sendRedirect("admin/index.jsp");
			} else {
				// If the credentials are incorrect, set an error message and redirect to the
				// admin login page.
				session.setAttribute("errorMsg", "Invalid email and password ");
				response.sendRedirect("admin_login.jsp");
			}
		} catch (Exception e) {
			// Handle any exceptions that may occur and print the stack trace for debugging.
			e.printStackTrace();
		}
	}

}
