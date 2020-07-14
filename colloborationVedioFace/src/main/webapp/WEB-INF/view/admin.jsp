<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body background="resources/login_background.jpg">
	<center>
		
		<h3 class="form-signin-heading" style="color:white;">Welcome to Admin Page</h3>
	</center>

	<div>
		<h4 class="card-title" style="color:white;">Click on UserList button to see user data</h4>
		<a href="UserList" class="btn btn-primary" title="UserList">UserList</a>
	</div>
</body>
</html>