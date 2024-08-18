
package com.hospital.billingServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hospital.dao.HospitalBillingDAO;
import com.hospital.db.DbConnect;

import com.hospital.entity.HospitalBilling;

@WebServlet("/addbillingdetails")
public class AddBillingDetails extends HttpServlet {

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
			

			HospitalBilling billing = new HospitalBilling();

			HospitalBillingDAO dao = new HospitalBillingDAO(DbConnect.getConn());
			HttpSession session = request.getSession();

			if (dao.addBilling(billing)) {
				session.setAttribute("succMsg", "Billing Added Successfully");
				response.sendRedirect("addbilling_details.jsp");
			} else {
				session.setAttribute("errorMsg", "Something went wrong");
				response.sendRedirect("addbilling_details.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
