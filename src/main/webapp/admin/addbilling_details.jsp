<%-- <%-- <%@page import="com.hospital.entity.Specialist"%>
<%@page import="com.hospital.dao.DoctorDao"%>
<%@page import="com.hospital.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.hospital.entity.Doctor"%>
<%@page import="com.hospital.db.DbConnect"%>
<%@page import="com.hospital.dao.SpecialistDao"%> --%>
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

			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Billing Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="addbillingdetails" method="post">
							<div class="mb-3">
								<label class="form-label">Invoice Number</label><input
									type="text" required name="invoiceNumber" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Customer Name</label><input
									type="text" required name="customerName" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Billing Address</label><input
									type="text" required name="billingAddress" class="form-control">
							</div>


							<div class="mb-3">
								<label class="form-label">Total Amount</label><input type="text"
									required name="totalAmount" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Billing Date</label><input type="date"
									required name="billingDate" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>

				</div>


			</div>




		</div>

	</div>

</body>
</html> --%>