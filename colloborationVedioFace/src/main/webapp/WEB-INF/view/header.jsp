<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
			<div class="card" style="width: 50px">
				<img class="card-img-top" src="resources/logo1.jpg"
					alt="Card image"> 
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="navbar-brand" href="index" title="Home">Home</a>
					
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	 
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav  ml-auto mr-1">
			<security:authorize access="isAnonymous()">

				<li class="nav-item" ><a class="nav-link" href="login" title="SignIn">SignIn</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="register" title="SignUp">SignUp</a>
				</li>
			</security:authorize>
			<%-- <security:authorize access="hasRole('ROLE_USER')">

				<li class="nav-item"><a class="nav-link" href="tik">Profile</a>
				</li>
			</security:authorize>
 --%>
			<security:authorize access="hasRole('ROLE_USER')">

				<li class="nav-item"><a class="nav-link" href="chat" title="ChatBox">ChatBox</a>
				</li>
			</security:authorize>
			<%--  <security:authorize access="hasRole('ROLE_USER')">			
      
      <li class="nav-item">
        <a class="nav-link" href="vedio">VideoChat</a>
      </li>
      </security:authorize> --%>
			<security:authorize access="hasRole('ROLE_USER')">

				<li class="nav-item"><a class="nav-link" href="addGroup" title="GroupChat">GroupChat</a>
				</li>
			</security:authorize>
			
			
    
    <security:authorize access="isAuthenticated()" >
      <li class="nav-item">
        <a class="nav-link" href="logout" title="Logout">Logout</a>
      </li>  
      </security:authorize>   
      </ul>
</div>
	</div>
	</nav>
</body>
</html>
