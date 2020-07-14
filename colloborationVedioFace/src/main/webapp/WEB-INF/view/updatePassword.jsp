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
			<spring:form action="passwordUpdate" modelAttribute="userInfo"
				method="POST">
				<h3 class="form-signin-heading" style="color:white;">Update Password</h3>
				<hr class="colorgraph">
				<br>


				<div class="form-group">
					<b><label for="password">Password:</label></b>
					<spring:input type="password" class="form-control" id="password"
						placeholder="Enter password" path="password" />

				</div>

				<div class="form-group">
					<b><label for="confrimPassword">Confrim Password:</label></b>
					<spring:input type="password" class="form-control"
						id="confrimPassword" placeholder="Enter confrim Password"
						path="confrimPassword" />
						
						<br>



					<button class="btn btn-lg btn-primary btn-block">Submit</button>
			</spring:form>
		</div>
	</div>
</body>
</html>





