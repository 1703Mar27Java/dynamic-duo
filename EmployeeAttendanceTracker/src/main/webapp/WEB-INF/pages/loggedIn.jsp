<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<%String userName = (String)session.getAttribute("userName"); %>
	<%String userRole = (String)session.getAttribute("userRole"); %>
</head>
<body>
	Logged In
	<div id = "welcome">
		<h2>Welcome ${userName}</h2>
		<p>You are a ${userRole}</p>
	</div>
	<form id = "Logout" method="GET" action="log" commandName="user">
		<input class = "lbl" type="submit" value="Logout" />
	</form>
</body>
</html>