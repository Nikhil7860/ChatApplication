<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body background="resources/login_background.jpg">

	<center><h1 style="color:white;">WELCOME TO USER PAGE</h1></center>
	<div class="container">
		<div class="wrapper">
			<c:url var="edit" value="/edit"></c:url>
			<spring:form action="${edit}" modelAttribute="userInfo" method="POST">
				<h3 class="form-signin-heading" style="color:white;">Update Profile</h3>
				<hr class="colorgraph">
				<br>
				<div class="form-group" style="color:white;">
					<b><label for="userId">UserId:</label></b>
					<spring:input type="text" class="form-control" id="userId"
						placeholder="Enter UserId" path="userId" />
				</div>

				<div class="form-group" style="color:white;">
					<b><label for="userName">UserName:</label></b>
					<spring:input type="text" class="form-control" id="userName"
						placeholder="Enter Username" path="userName" />
				</div>
				<div class="form-group" style="color:white;">
					<b><label for="password">Password:</label></b>
					<spring:input type="password" class="form-control" id="password"
						placeholder="Enter password" path="password" />
				</div>
				<div class="form-group" style="color:white;">
					<b><label for="confrimPassword">Confrim Password:</label></b>
					<spring:input type="password" class="form-control"
						id="confrimPassword" placeholder="Enter confrim Password"
						path="confrimPassword" />

				</div>

				<div class="form-group" style="color:white;">
					<b><label for="userEmail">EmailId:</label></b>
					<spring:input type="userEmail" class="form-control" id="userEmail"
						placeholder="Enter EmailId" path="userEmail" />
				</div>


				<button type="submit" class="btn btn-primary" title="Update">Update
					Profile</button>
			</spring:form>
			<br> 
			
			<div class="text-right">
					<a href="tok" class="btn btn-primary" title="Delete Account" >Delete Account Permanently</a>
			</div>
		</div>
		
	</div>
	
</body>
</html>