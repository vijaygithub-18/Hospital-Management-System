
<%@page import="com.hospital.dao.HospitalBillingDAO"%>
<%@page import="com.hospital.entity.HospitalBilling"%>
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
						<p class="fs-3 text-center">Billing Details</p>
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
									<th scope="col">Patient Name</th>
									<th scope="col">Patient Id</th>
									<th scope="col">Diagnosis</th>
									<th scope="col">Treatment</th>
									<th scope="col">TotalAmount</th>
									<th scope="col">InsuranceProvider</th>
									<th scope="col">InsuranceCoverage</th>
									<th scope="col">AmountDue</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
                                   HospitalBillingDAO dao2=new HospitalBillingDAO(DbConnect.getConn());
                                    List<HospitalBilling> list2=dao2.getAllBillings();
                                       for(HospitalBilling b:list2)
                               {%>
								<tr>
									<td>
										<%=b.getPatientName()%>
									</td>
									<td>
										<%=b.getPatientID()%>
									</td>
									<td>
										<%=b.getDiagnosis()%>
									</td>
									<td>
										<%=b.getTreatment()%>
									</td>
									<td>
										<%=b.getTotalAmount()%>
									</td>
									<td>
										<%=b.getInsuranceProvider()%>
									</td>
									<td>
										<%=b.getInsuranceCoverage()%>
									</td>
									<td>
										<%=b.getAmountDue()%>
									</td>
									<td><a href="edit_billingDetails.jsp?id=<%=b.getBillingId()%>"
										class="btn btn-sm btn-primary">Edit</a> <a 
										href="deleteWorker?id=<%=b.getBillingId()%>"
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