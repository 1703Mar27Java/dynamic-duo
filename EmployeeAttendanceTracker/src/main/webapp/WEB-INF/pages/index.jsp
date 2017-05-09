<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="eat.js"></script>
<link rel="stylesheet" href="style.css"/>

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
<li><a href="<%=request.getContextPath() %>/user/log">Home</a></li>
<li><a href="<%=request.getContextPath() %>/user/contact">Contact Us</a> </li>
<li><a href="<%=request.getContextPath() %>/user/tech">Technical Assistance</a> </li>
<li><a href="<%=request.getContextPath() %>/user/about">About Us</a> </li>
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
 
<form id = "LoginForm" method="POST" action="loggedIn" commandName="user">
  <div class="form-group">
  <br/>

    <label for="username">Username:</label>
    <input type="text" class="form-control" id="email" path="userName">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd"  path="password">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button id ="LoginSubmit" type="submit" class="btn btn-default">Submit</button>
<br/>
<br/>
</form>
<button id ="RegisterButton" type="submit" class="btn btn-default">Register</button>

<form id = "RegisterForm" method="POST" action="loggedIn" commandName="user">
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
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button id ="RegisterSubmit" type="submit" class="btn btn-default">Submit</button>
<br/>
<br/>
</form>
</div>

<div class="col-md-4"></div>
</div>
</div>

</div>

</body>

<script>
	$(document).ready(function(){
		$("#RegisterForm").hide();
		
		$("#RegisterButton").click(function(){
			$("#LoginForm").hide();
			$("#RegisterButton").hide();
			$("#RegisterForm").show();
			$("#message").text("Register");
		});
	});
	
</script>
</html>
