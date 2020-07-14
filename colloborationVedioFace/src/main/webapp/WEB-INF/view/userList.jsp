<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
</head>
<body background="resources/login_background.jpg">
<%-- 
	<c:if test="${pageContext.request.userPrincipal.getroleName !=('ROLE_ADMIN')}">

		<li><a href="<c:url value="/admin/*"/>" Admin</a></li>

	</c:if>
 --%>


	<div class="container">
		<div class="wrapper">
			<center>
				<h3 class="form-signin-heading" style="color:white;">Welcome to AdminUserList</h3>
			</center>
			<hr class="colorgraph" >
			<br>
			<table class="table table-hover" style="color:white;">
				<thead>
					<tr>
						<th>UserId</th>
						<th>Name</th>
						<th>Emailid</th>
						<th>Phone</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${userList}" var="userInfo">
						<tr>
							<td>${userInfo.userId}</td>
							<td>${userInfo.userName}</td>
							<td>${userInfo.userEmail}</td>
							<td>${userInfo.phone}</td>
							<td><a href="<c:url value='/update/${userInfo.userId}'/>" title="UpdateUser">Update
									User </a></td>
							<td><a href="<c:url value='/Delete/${userInfo.userId}'/>" title="DeleteUser">Delete
									User</a></td>

						</tr>
					</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>