
<%@page import="com.hospital.dao.StaffDao"%>
<%@page import="com.hospital.db.DbConnect"%>
<%@page import="com.hospital.entity.Staff"%>
<%@ page import = "java.util.List" %>
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

	<div class="container-fluid p-3">
		<div class="row">

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Staff</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<%
						int id=Integer.parseInt(request.getParameter("id"));
						StaffDao dao2=new StaffDao(DbConnect.getConn()); 
						//dao2.getDoctorById(id);
						Staff s=dao2.getStaffById(id);
						
						%>
						<form action="../updateStaff" method="post">
							<div class="mb-3">
								<label class="form-label">First Name</label><input type="text"
									value="<%=s.getFname() %>" required name="fname" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Last Name</label><input type="text" required
									value="<%=s.getLname() %>" name="lname" class="form-control">
							</div>


							<div class="mb-3">
								<label class="form-label">Role</label><input type="text"
									value="<%=s.getRole() %>" required name="role" class="form-control">
							</div>


							<div class="mb-3">
								<label class="form-label">Department</label><input type="text"
									value="<%=s.getDepartment() %>" required name="department" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email</label><input type="email"
									value="<%=s.getEmail() %>" required name="email" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Phone</label><input type="text"
									value="<%=s.getPhone() %>" required name="phone" class="form-control">
							</div>
							
							<input type="hidden" name="id" value="<%=s.getid() %>">
							
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
							
						</form>
					</div>

				</div>


			</div>

		
		</div>

	</div>
</body>
</html>