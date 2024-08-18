
<%@page import="com.hospital.dao.HospitalBillingDAO"%>
<%@page import="com.hospital.db.DbConnect"%>
<%@page import="com.hospital.entity.HospitalBilling"%>
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
						<p class="fs-3 text-center">Edit Worker</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<%
						int billingId=Integer.parseInt(request.getParameter("billingId"));
						HospitalBillingDAO dao2=new HospitalBillingDAO(DbConnect.getConn()); 
						//dao2.getDoctorById(id);
						HospitalBilling b=dao2.getBillingById(billingId);
						
						%>
						<form action="../UpdateBilling" method="post">
							<div class="mb-3">
								<label class="form-label">Patient Name</label><input type="text"
									value="<%=b.getPatientName() %>"  class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Pateint ID</label><input type="text" 
									value="<%=b.getPatientID() %>" class="form-control">
							</div>


							<div class="mb-3">
								<label class="form-label">Diagnosis</label><input type="text"
									value="<%=b.getDiagnosis() %>"  class="form-control">
							</div>


							<div class="mb-3">
								<label class="form-label">Treatment</label><input type="text"
									value="<%=b.getTreatment() %>"   class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Total Amount</label><input type="text"
									value="<%=b.getTotalAmount() %>"  class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Insurance Provider</label><input type="text"
									value="<%=b.getInsuranceProvider() %>"  class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Insurance Coverage</label><input type="text"
									value="<%=b.getInsuranceCoverage() %>"  class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Amount Due</label><input type="text"
									value="<%=b.getAmountDue() %>"  class="form-control">
							</div>
							
							<input type="hidden" name="billingId" value="<%=b.getBillingId() %>">
							
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
							
						</form>
					</div>

				</div>


			</div>

		
		</div>

	</div>
</body>
</html>