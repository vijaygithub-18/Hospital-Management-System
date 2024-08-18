<%@page import="com.hospital.dao.AppointmentDao"%>
<%@page import="com.hospital.entity.Appointment"%>
<%@ page import="java.util.List"%>
<%@page import="com.hospital.db.DbConnect"%>
<%@page import="com.hospital.entity.Doctor"%>
<%@page import="com.hospital.dao.DoctorDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<%@include file="navbar.jsp"%>

	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>

					<tbody>
					
					<%
					        DoctorDao dao2=new DoctorDao(DbConnect.getConn());
							AppointmentDao dao = new AppointmentDao(DbConnect.getConn());
							List<Appointment> list = dao.getAllAppointment();
							for (Appointment ap : list) {
								Doctor d=dao2.getDoctorById(ap.getDoctorId());
						%>
						<tr>
							<th><%=ap.getFullName() %></th>
							<td><%=ap.getGender() %></td>
							<td><%=ap.getAge() %></td>
							<td><%=ap.getAppointDate() %></td>
							<td><%=ap.getEmail() %></td>
							<td><%=ap.getPhNo() %></td>
							<td><%=ap.getDiseases() %></td>
							<td><%=d.getFullName() %></td>
							<td><%=ap.getAddress() %></td>
							<td><%=ap.getStatus() %></td>
							<td>
						<a href="comment.jsp?id=<%=ap.getId() %>" class="btn btn-success btn-sm">Comment</a>
						</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>