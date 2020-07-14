<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
</head>
<body background="resources/login_background.jpg">
	
	<h3 class="form-signin-heading" style="color:white;">Forget Password</h3>
	<spring:form action="forgten" modelAttribute="userInfo" method="GET">


		<div class="form-group">
			<b><label for="userEmail">EmailId:</label></b>
			<spring:input type="userEmail" class="form-control" id="userEmail"
				placeholder="Enter EmailId" path="userEmail" />
		</div>


		<button type="submit" class="btn btn-primary">Generate OTP</button>
	</spring:form>

</body>
</html>