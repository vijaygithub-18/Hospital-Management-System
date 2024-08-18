<%@page import="com.hospital.dao.DoctorDao"%>
<%@page import="com.hospital.dao.StaffDao"%>
<%@page import="com.hospital.dao.PatientDao"%>
<%@page import="com.hospital.db.DbConnect"%>

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

	<div class="container p-5">
		<p class="text-center fs-3">Admin Dashboard</p>
		<c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty succMsg}">
			<div class="fs-3 text-center text-success role="alert">${succMsg}</div>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<%
		

				DoctorDao dao = new DoctorDao(DbConnect.getConn());
				StaffDao dao2 = new StaffDao(DbConnect.getConn());
				PatientDao dao3 = new PatientDao(DbConnect.getConn());
		%>


		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor <br><%=dao.countDoctor()%>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment <br><%=dao.countAppointment()%>
						</p>
					</div>
				</div>
			</div>


			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text center text-success">
						<i class="fas fa-user-circle fa-3x"></i><br>
						<p class="fs-4 text-center">
							Patient <br><%=dao3.countPatient()%>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 mt-2">
				<div class="card paint-card">
					<div class="card-body text center text-success">
						<i class="fas fa-user-circle fa-3x"></i><br>
						<p class="fs-4 text-center">
							Staff <br><%=dao2.countStaff()%>
						</p>
					</div>
				</div>
			</div>



			<div class="col-md-4 mt-2">

				<div class="card paint-card" data-bs-toggle="modal"
					data-bs-target="#exampleModal">
					<div class="card-body text center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Specialist <br><%=dao.countSpecialist()%>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Button trigger modal -->
	<!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#exampleModal">Launch demo modal</button>
 -->
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="..//addSpecialist" method="post">

						<div class="form group">
							<label>Enter Specialist Name</label><input type="text"
								name="specName" class="form-control">
						</div>
						<div class="text-center mt-3">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
					</form>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>