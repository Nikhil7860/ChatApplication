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
			<spring:form action="otpverify" modelAttribute="userInfo"
				method="GET">
				<h3 class="form-signin-heading" style="color:white;">${title }</h3>
				<hr class="colorgraph">
				<br>

				<div class="form-group">
					<b><label for="otp">Enter your OTP here :</label></b>
					<spring:input type="number" class="form-control" id="otp"
			required="true" placeholder="Enter your OTP number" value="null" path="otp"  />
				</div>


				<button class="btn btn-lg btn-primary btn-block">Verify OTP</button>

			</spring:form>
		</div>
	</div>
</body>
</html>





