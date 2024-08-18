<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allcss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0.3);
}
body {
	background-image:
		url('img/expenses.jpg');
	/* Replace with your image path */
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
}
</style>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Billing Form</p>

						<form action="addbillingdetails" method="post">
							<input type="hidden" name="action" value="add">
							<div class="mb-3">
								<label class="form-label">Patient Name</label><input type="text"
									required name="patientName" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Patient Id</label><input type="text"
									required name="patientID" class="form-control">
							</div>


							<div class="mb-3">
								<label class="form-label">Diagnosis</label><input type="text"
									required name="diagnosis" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Treatment</label><input type="text"
									required name="treatment" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">TotalAmount</label><input type="text"
									required name="totalAmount" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">InsuranceProvider</label><input
									type="text" required name="insuranceProvider"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">InsuranceCoverage</label><input
									type="text" required name="insuranceCoverage"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">AmountDue</label><input type="text"
									required name="amountDue" class="form-control">
							</div>


							<button type="submit" class="btn btn-primary">Submit</button>
							<!-- <input type="submit" value="Add Billing"> -->
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>