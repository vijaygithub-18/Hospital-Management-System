package com.hospital.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.StaffDao;
import com.hospital.db.DbConnect;

//This annotation defines the URL mapping for this servlet.
@WebServlet("/deleteStaff")
public class DeleteStaff extends HttpServlet {

	// This method handles HTTP GET requests.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Extract the ID of the worker to be deleted from the request parameter.
		int id = Integer.parseInt(request.getParameter("id"));

		// Create a StaffDao instance with a database connection.
		StaffDao dao = new StaffDao(DbConnect.getConn());
		HttpSession session = request.getSession();

		// Attempt to delete the worker with the specified ID.
		if (dao.deleteStaff(id)) {
			// If deletion is successful, set a success message and redirect to the view
			// worker page.
			session.setAttribute("succMsg", "Staff Delete Successfully");
			response.sendRedirect("admin/view_staff.jsp");
		} else {
			// If deletion fails, set an error message and redirect to the view worker page.
			session.setAttribute("errorMsg", "Something went wrong");
			response.sendRedirect("admin/view_staff.jsp");
		}
	}

}
