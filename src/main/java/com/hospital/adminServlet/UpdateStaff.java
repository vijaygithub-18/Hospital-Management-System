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
import com.hospital.entity.Staff;

//This annotation defines the URL mapping for this servlet.
@WebServlet("/updateStaff")
public class UpdateStaff extends HttpServlet {
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

			// Extract the ID of the worker to be updated from the request parameter.
			int id = Integer.parseInt(request.getParameter("id"));

			// Create a Worker object with the updated data.
			Staff s = new Staff(id,fname,lname,role,department,email,phone);

			// Create a StaffDao instance with a database connection.
			StaffDao dao = new StaffDao(DbConnect.getConn());
			HttpSession session = request.getSession();

			// Attempt to update the worker's information in the database.
			if (dao.updateStaff(s)) {
				// If the update is successful, set a success message and redirect to the view
				// worker page.
				session.setAttribute("succMsg", "Staff Updated Successfully");
				response.sendRedirect("admin/view_staff.jsp");
			} else {
				// If the update fails, set an error message and redirect to the view worker
				// page.
				session.setAttribute("errorMsg", "Something went wrong");
				response.sendRedirect("admin/view_staff.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
