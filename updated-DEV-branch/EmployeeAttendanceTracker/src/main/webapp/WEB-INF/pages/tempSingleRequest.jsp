<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />

<spring:url value="/resources/js/eat.js" var="eatJs" />
<script src="${eatJs}"></script>
<title>Insert title here</title>
</head>

<div class="container" align="center">
		<h1>
			<strong>Employee Attendance Tracker</strong>
			
		</h1>
		<h3><strong>Managers</strong></h3>	
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
			<h2>View Single Attendance Record</h2>
<div>	${mostRecentRequest}</div>

	</div>
</body>
</html>