package com.hospital.billingServlet;

import com.hospital.dao.HospitalBillingDAO;
import com.hospital.dao.StaffDao;
import com.hospital.db.DbConnect;
import com.hospital.entity.HospitalBilling;
import com.hospital.entity.Staff;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateBilling")
public class UpdateBillingServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String patientName = request.getParameter("patientName");
			String patientID = request.getParameter("patientID");
			String diagnosis = request.getParameter("diagnosis");
			String treatment = request.getParameter("treatment");
			String totalAmount = request.getParameter("totalAmount");
			String insuranceProvider = request.getParameter("insuranceProvider");
			String insuranceCoverage = request.getParameter("insuranceCoverage");
			String amountDue = request.getParameter("amountDue");

			int billingId = Integer.parseInt(request.getParameter("billingId"));

			HospitalBilling billing = new HospitalBilling();

			HospitalBillingDAO dao = new HospitalBillingDAO(DbConnect.getConn());
			HttpSession session = request.getSession();

			if (dao.updateBilling(billing)) {
				session.setAttribute("succMsg", "Billing Details Updated Successfully");
				response.sendRedirect("admin/edit_billingDetails.jsp");
			} else {
				session.setAttribute("errorMsg", "Something went wrong");
				response.sendRedirect("admin/edit_billingDetails.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
