<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<security:authorize access="hasRole('ROLE_ADMIN')">
	<jsp:forward page="/admin/Home"></jsp:forward>
</security:authorize>

<security:authorize access="hasRole('ROLE_USER')">
	<jsp:forward page="/user/Home"></jsp:forward>
</security:authorize>






<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title }</title>
</head>
<body background="resources/login_background.jpg">
	<div>

		<center>
			<h3 class="form-signin-heading" style="color: white;">ChatApp</h3>
		</center>

		<center>
			<h4 class="form-signin-heading" style="color: white;">Chat App
				helps you connect and share with the people in your life</h4>
		</center>
		<table width="100%" >
			<tr>
				<td>
					<div class="card" style="width: 500px">
						<img class="card-img-top" src="resources/image1.png"
							alt="Card image" width="100%">
					</div>
				</td>
				 <td>
				<center>  <h4 class="form-signin-heading" style="color: white;">Helps you Stay in touch with you family and friends</h4></center>
				<center>  <h4 class="form-signin-heading" style="color: Green;">Stay Connected</h4></center>
				<center>  <h4 class="form-signin-heading" style="color: blue;">Connect From anywhere around the globe</h4></center>

				</td> 
			</tr>
		</table>

	</div>
</body>
</html>


