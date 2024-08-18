
<%@page import="com.hospital.dao.StaffDao"%>
<%@page import="com.hospital.entity.Staff"%>
<%@page import="java.util.List"%>
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

	<div class="container-fluid p-3">
		<div class="row">


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Staff Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">First Name</th>
									<th scope="col">Last Name</th>
									<th scope="col">Role</th>
									<th scope="col">Department</th>
									<th scope="col">Email</th>
									<th scope="col">Phone</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
                                   StaffDao dao2=new StaffDao(DbConnect.getConn());
                                    List<Staff> list2=dao2.getAllStaff();
                                       for(Staff s:list2)
                               {%>
								<tr>
									<td>
										<%=s.getFname()%>
									</td>
									<td>
										<%=s.getLname()%>
									</td>
									<td>
										<%=s.getRole()%>
									</td>
									<td>
										<%=s.getDepartment()%>
									</td>
									<td>
										<%=s.getEmail()%>
									</td>
									<td>
										<%=s.getPhone()%>
									</td>
									<td><a href="edit_staff.jsp?id=<%=s.getid()%>"
										class="btn btn-sm btn-primary">Edit</a> <a 
										href="../deleteStaff?id=<%=s.getid()%>"
										class="btn btn-sm btn-danger">Delete</a></td>
								</tr>
								<%
								}
                                %>

							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>

	</div>
	
</body>
</html>