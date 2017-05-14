<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <spring:url value="/resources/css/style.css" var="styleCss" />

<link href="${styleCss}" rel="stylesheet" />
<spring:url value="/resources/js/eat.js" var="eatJs" />
<script src="${eatJs}"></script>
 
<title>All Employees</title>
</head>
<body>
<div class="container" align="center">
		<h1>
			<strong>Employee Attendance Tracker</strong>
		</h1>
		<br /> <br />

		<div class="container-fluid" align="center">
			<div class="row">
				<ul class="nav nav-tabs" role="tablist">
					<li><a href="<%=request.getContextPath()%>/user/log">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/user/contact">Contact
							Us</a></li>
					<li><a href="<%=request.getContextPath()%>/user/tech">Technical
							Assistance</a></li>
					<li><a href="<%=request.getContextPath()%>/user/about">About
							Us</a></li>
				</ul>
			</div>
		</div>
		<br /> 

<div class="container">
<h2>Records for All Employees</h2>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4">


${employees}
	<p>Username: ${username}</p>
	<p>First Name: ${firstName}</p>
	<p>Last Name: ${lastName}</p>
	<p>User ID: ${userID}</p>
	<p>Email Address: ${email}</p>
	


</div>
<div class="col-md-4"></div>
</div>
</div>
	
<table>
<tr>
<c:forEach items="${employees}" var="userForm">
		<td></td>
</c:forEach>
</tr>
</table>

</body>
</html>
