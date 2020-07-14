<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>${title}</title>
</head>
<body background="resources/login_background.jpg">
	<div class="container">
		<div class="wrapper">
			<spring:form action="Sucess" modelAttribute="userInfo" method="POST">
				<h3 class="form-signin-heading" style="color:white;">Registration Form</h3>
				<hr class="colorgraph">
				<br>
				<div class="form-group" style="color:white;">
					<b><label for="userName">UserName:</label></b>
					<spring:input type="text" class="form-control" id="userName"
						placeholder="Enter Username" required="true" path="userName" />
				</div>


				<div class="form-group" style="color:white;">
					<b><label for="userEmail">Email:</label></b>
					<spring:input type="email" class="form-control" id="userEmail"
						placeholder="Enter EmailId" required="true" path="userEmail" />

				</div>

				<div class="form-group" style="color:white;">
					<b><label for="password">Password:</label></b>
					<spring:input type="password" class="form-control" id="password"
						placeholder="Enter password" required="true" path="password" />

				</div>

				<div class="form-group" style="color:white;">
					<b><label for="confrimPassword">Confrim Password:</label></b>
					<spring:input type="password" class="form-control"
						id="confrimPassword" placeholder="Enter confrim Password"
						required="true" path="confrimPassword" />

				</div>

				<div class="form-group" style="color:white;">
					<b><label for="phone">Phone Number :</label></b>
					<spring:input type="number" maxlength="12" pattern="\d{10}" class="form-control" id="phone"
						 required="true" placeholder="Enter your phone number" value="null"  path="phone" />

				</div>


				<button class="btn btn-lg btn-primary btn-block">Register</button>

			</spring:form>
		</div>
	</div>
</body>
</html>





