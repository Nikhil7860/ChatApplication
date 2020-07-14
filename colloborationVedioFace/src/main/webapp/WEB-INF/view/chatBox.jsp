<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Chat Application</title>
<link rel="stylesheet" href="resources/chat.css" />
</head>
<body background="resources/login_background.jpg">
	<noscript>
		<h2>Sorry! Your browser doesn't support Javascript</h2>
	</noscript>

	<div id="username-page">
		<div class="username-page-container">
			<h1 class="title">Enter Name and Room ID</h1>
			<form id="usernameForm" name="usernameForm">
				<div class="form-group">
					<input type="text" id="name" placeholder="Username"
						autocomplete="off" class="form-control" />
				</div>
				<div class="form-group">
					<input type="number" id="room-id" value="lobby"  placeholder="Room ID"
						autocomplete="off" class="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="accent username-submit">Start
						Chatting</button>
				</div>
			</form>
		</div>
	</div>

	<div id="chat-page" class="hidden">
		<div class="chat-container">
			<div class="chat-header">
				<h2>
					Chatroom [<span id="room-id-display"></span>]
				</h2>
			</div>
			<div class="connecting">Connecting...</div>
			<ul id="messageArea">

			</ul>
			<form id="messageForm" name="messageForm" nameForm="messageForm">
				<div class="form-group">
					<div class="input-group clearfix">
						<input type="text" id="message"
							placeholder="Type a message... "
							autocomplete="off" class="form-control" />
						<button type="submit" class="primary">Send</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="resources/chat.js"></script>
</body>
</html>