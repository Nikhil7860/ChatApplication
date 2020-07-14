<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
<style>
.logintext{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
</style>

</head>
<body background="resources/login_background.jpg">
	
	<div class="container">
	
		<div class="wrapper">
		
			<form action="login" method="post" name="Login_Form"
				class="form-signin">
			
				<h3 class="form-signin-heading" style="color:white;"> Sign In</h3>
				<hr class="colorgraph">
				<br>

				<div style="color:white;">
					<b>Email:</b> <input type="email" class="form-control" name="Email"
						placeholder="Email" required=""/>
				</div>
				<br>
				<div style="color:white;">
					<b>Password:</b> <input type="password" class="logintext"
						name="password" placeholder="Password" required="" />
				</div>
				<br>

				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Login" type="Submit"title="Login">Login</button>
					
			</form>
			<br>
			
				<a href="forget" title="Forgot Password"> Forgotten account? </a>
			<br>
			<br>
			<br>
			
		</div>
		
	</div>
	
</body>
</html>