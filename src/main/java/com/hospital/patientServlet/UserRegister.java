package com.hospital.patientServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.PatientDao;
import com.hospital.db.DbConnect;
import com.hospital.entity.Patient;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {
	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try{
				String fullName=request.getParameter("fullname");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				
				Patient p = new Patient(fullName, email, password);
				
				PatientDao dao = new PatientDao(DbConnect.getConn());
				
				HttpSession session=request.getSession();
				
				boolean f=dao.PatientRegister(p);
				
				if(f){
					session.setAttribute("sucMsg","Register Successfully");
					response.sendRedirect("signup.jsp");
				}else{
					session.setAttribute("errorMsg","Something went wrong");
					response.sendRedirect("signup.jsp");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	}

}
