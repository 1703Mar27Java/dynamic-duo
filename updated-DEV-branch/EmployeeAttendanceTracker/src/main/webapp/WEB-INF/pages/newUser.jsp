<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />

<spring:url value="/resources/js/eat.js" var="eatJs" />
<script src="${eatJs}"></script>


<title>Create New User</title>
</head>
<body>
 <p>${userRoles}</p>
<div class="container" align="center">
<h1><strong>Employee Attendance Tracker</strong></h1>
<h3>Create New Account</h3>
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
 <h2>Please fill in the form below<br/> to create a new account!</h2>
 <br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" id="form">
 
<form:form id = "NewUserForm" action="newUser" commandName="userForm">
 <div class="form-group">
 <br/>
    <label for="userrole">Select User Role</label>
	<select class="form-control" id="userrole" name="userrole">
      <option id="Employee">Employee</option>
      <option id="Manager">Manager</option>
      <form:input id = "hiddenRoleForm" type="hidden" class="form-control" path="userRole" size="30"/>
  </select>
   </div>
   
  <div class="form-group">
 		 <label for="username">Username:</label>
    	<form:input class="form-control" path="userName" size="30"/>
    	<form:errors cssClass="error" path="userName" style="color:red; font-style:italic"/>
    </div>
     <div class="form-group">
    	<label for="pwd">First Name:</label>
    	<form:input class="form-control" path="firstName" size="30"/>
    	<form:errors path="firstName" cssClass="error" style="color:red; font-style:italic"/>
    </div>
     <div class="form-group">
    	<label for="pwd">Last Name:</label>
    	<form:input class="form-control" path="lastName" size="30"/>
    	<form:errors path="lastName" cssClass="error" style="color:red; font-style:italic"/>
    </div>
     <div class="form-group">
    	<label for="pwd">Email Address:</label>
    	<form:input class="form-control" path="emailAddress" size="30"/>
    	<form:errors path="emailAddress" cssClass="error" style="color:red; font-style:italic"/>
    </div>
    <div class="form-group">
    	<label for="pwd">Password:</label>
    	<form:input class="form-control" path="password" size="30"/>
    	<form:errors path="password" cssClass="error" style="color:red; font-style:italic"/>
  	</div>
    
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>

  <button type="submit" class="btn btn-default">Submit</button>
<br/>
<br/>
</form:form>
</div>

<div class="col-md-4"></div>
</div>
</div>

</body>
<script>
$(document).ready(
	//JQUERY
	//handle notifications
	function(){
		$("#Employee").on("click",function(){
			  $("#hiddenRoleForm").val('Employee');
		})
		$("#Manager").on("click",function(){
			  $("#hiddenRoleForm").val('Manager');
		})
	}
);
</script>
</html>