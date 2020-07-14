
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
	
	<h3 class="form-signin-heading" style="color:Red;">Delete Account Permanently</h3>
	<c:url var="del" value="/del"></c:url>
	<spring:form action="${del}" modelAttribute="userInfo" method="GET">

		<div class="form-group">
			<b><label for="userId">userId:</label></b>
			<spring:input type="userId" class="form-control" id="userId"
				placeholder="Enter userId" path="userId" />

		</div>




		<input type="submit" class="btn btn-primary"
			value="Delete Permanently" style="color:Red;"/>
	</spring:form>

</body>
</html>