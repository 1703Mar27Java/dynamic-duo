<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<<<<<<< HEAD
<html>
<head>
=======
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />

<spring:url value="/resources/js/eat.js" var="eatJs" />
<script src="${eatJs}"></script>


>>>>>>> HackworthA
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<<<<<<< HEAD
<script src="eat.js"></script>
<link rel="stylesheet" href="style.css"/>
=======
>>>>>>> HackworthA

<title>Employee Attendance Tracker</title>
</head>
<body>

<div class="container" align="center">
<h1><strong>Employee Attendance Tracker</strong></h1>
<br/>
<br/>

<div class="container-fluid" align="center">
<div class="row">
<ul class="nav nav-tabs" role="tablist">
<<<<<<< HEAD
<li><a href="index.jsp">Home</a></li>
<li><a href="contact.jsp">Contact Us</a> </li>
<li><a href="tech.jsp">Technical Assistance</a> </li>
<li><a href="about.jsp">About Us</a> </li>
=======
<li><a href="<%=request.getContextPath() %>/user/log">Home</a></li>
<li><a href="<%=request.getContextPath() %>/user/contact">Contact Us</a> </li>
<li><a href="<%=request.getContextPath() %>/user/tech">Technical Assistance</a> </li>
<li><a href="<%=request.getContextPath() %>/user/about">About Us</a> </li>
>>>>>>> HackworthA
</ul>
</div>
</div>
<br/>
<br/>
<br/>

<div class="form-container">
 <h2 id = "message">Please sign in below:</h2>
 <br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" id="form">
<<<<<<< HEAD
 
<form id = "LoginForm" action = "register.jsp" method="post">
=======

<!-- Rounded switch -->
<table>
<tr>
<td>
<p id="toggleLable">New user? Click here to Register</p>
</td>
<td>
<label class="switch">
  <input type="checkbox" id="toggle">
  <div class="slider round"></div>
</label>
</td>
</tr>
</table>
 
<form:form id = "LoginForm" action="log" commandName="userForm">
>>>>>>> HackworthA
  <div class="form-group">
  <br/>

    <label for="username">Username:</label>
<<<<<<< HEAD
    <input type="text" class="form-control" id="email"  name="userName">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd"  name="password">
=======
    <form:input class="form-control" path="userName" size="30"/>
    <form:errors path="userName" cssClass="error" style="color:red; font-style:italic"/>
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <form:password class="form-control" path="password" size="30"/>
    <form:errors path="password" cssClass="error" style="color:red; font-style:italic"/>
>>>>>>> HackworthA
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
<<<<<<< HEAD
  <button id ="LoginSubmit" type="submit" class="btn btn-default">Submit</button>
<br/>
<br/>
</form>
<button id ="RegisterButton" type="submit" class="btn btn-default">Register</button>

<form id = "RegisterForm">
  <div class="form-group">
  <br/>

    <label for="username">Username:</label>
    <input type="text" class="form-control" id="email"  name="userName">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd"  name="password">
  </div>
   <div class="form-group">
    <label for="pwd">Confirm Password:</label>
    <input type="password" class="form-control" id="pwd"  name="password">
=======
  <span>
  <button id ="LoginSubmit" type="submit" class="btn btn-default">Submit</button>
  </span>
<br/>
<br/>
</form:form>

<form:form id = "RegisterForm" action="register" commandName="userForm">
  <div class="form-group">
  <br/>
 	<label for="username">Username:</label>
    <form:input class="form-control" path="userName" size="30"/>
    <form:errors path="userName" cssClass="error" style="color:red; font-style:italic"/>
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <form:password class="form-control" path="password" size="30"/>
    <form:errors path="password" cssClass="error" style="color:red; font-style:italic"/>
  </div>
   <div class="form-group">
    <label for="pwd">Confirm Password:</label>
    <form:password id ="pw2Form" class="form-control" path="password2" size="30"/>
    <label id="pwMatchWarning" style="color:red; font-style:italic">passwords have to match</label>
>>>>>>> HackworthA
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button id ="RegisterSubmit" type="submit" class="btn btn-default">Submit</button>
<br/>
<br/>
<<<<<<< HEAD
</form>
=======
</form:form>
>>>>>>> HackworthA
</div>

<div class="col-md-4"></div>
</div>
</div>

</div>

</body>

<script>
	$(document).ready(function(){
		$("#RegisterForm").hide();
		
<<<<<<< HEAD
		$("#RegisterButton").click(function(){
			$("#LoginForm").hide();
			$("#RegisterButton").hide();
			$("#RegisterForm").show();
			$("#message").text("Register");
		});
=======
		$("#toggle").change(function(){
			//alert("Switch 6 changed to " + ($(this).prop("checked") ? "checked" : "unchecked"));
			if ($(this).prop("checked") == true){
				$("#pwMatchWarning").hide();
				$("#LoginForm").hide();
				$("#RegisterForm").show();
				$("#message").text("Register");
				$("#toggleLable").text("Click here to Login")
				
				$("#pw2Form").click(function(){
					$("#pwMatchWarning").show();
				});
			}	
			else{
				$("#LoginForm").show();
				$("#RegisterForm").hide();
				$("#message").text("Login");
				$("#toggleLable").text("New user? Click here to Register")
			}
		});
		
>>>>>>> HackworthA
	});
	
</script>
</html>
