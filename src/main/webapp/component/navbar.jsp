<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa-sharp fa-solid fa-house-medical-circle-check"></i>MEDI HOME</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

				<c:if test="${empty userObj}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="admin_login.jsp"><i
							class="fa-solid fa-right-to-bracket"></i>ADMIN</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="doctor_login.jsp"><i
							class="fa-solid fa-user-doctor"></i>DOCTOR</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="patient_appointment.jsp"><i
							class="fa-solid fa-calendar-check"></i>APPOINTMENT</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="patient_login.jsp"><i
							class="fa-solid fa-users"></i>PATIENT</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="billingForm.jsp"><i
							class="fas fa-file-invoice-dollar"></i></i>BILLING</a></li>
				</c:if>



				<c:if test="${not empty userObj}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="patient_appointment.jsp">APPOINTMENT</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="view_appointment.jsp">VIEW
							APPOINTMENT</a></li>


					<div class="dropdown active">
						<button class="btn btn-primary dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">
							<i class="fa-solid fa-circle-user"></i>${userObj.fullname }</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="change_password.jsp">Change
									Password</a></li>
							<li><a class="dropdown-item" href="patientLogout">Logout</a></li>

						</ul>
					</div>

				</c:if>

			</ul>

		</div>
	</div>
</nav>