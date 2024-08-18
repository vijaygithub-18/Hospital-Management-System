<%@page import="com.hospital.dao.DoctorDao"%>
<%@page import="com.hospital.db.DbConnect"%>
<%@page import="com.hospital.entity.Doctor"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0.3);
}
</style>
</head>
<body>
	<c:if test="${empty doctObj}">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>
	<p class="text-center fs-3">Doctor Dashboard</p>

<%
Doctor d=(Doctor) session.getAttribute("doctObj");
DoctorDao dao=new DoctorDao(DbConnect.getConn());
%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-2">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i>
						<p class="fs-4 text-center"><i class="fa-duotone fa-user-doctor"></i>
							Doctor<br><%=dao.countDoctor() %>
						</p>
					</div>
				</div>
			</div>


			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment<br><%=dao.countAppointmentByDoctorId(d.getId()) %>
						</p>
					</div>
				</div>

			</div>
		</div>

	</div>
	
</body>
</html>