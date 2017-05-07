<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Managers</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="eat.js"></script>
<link rel="stylesheet" href="style.css"/>
</head>
<body>
<div class="container" align="center">
<h1><strong>Employee Attendance Tracker</strong></h1>
<h3><strong>Managers</strong></h3>
<br/>
<br/>

<div class="container-fluid" align="center">
<div class="row">
<ul class="nav nav-tabs" role="tablist">
<li><a href="index.jsp">Home</a></li>
<li><a href="contact.jsp">Contact Us</a> </li>
<li><a href="tech.jsp">Technical Assistance</a> </li>
<li><a href="about.jsp">About Us</a> </li>
</ul>
</div>
</div>
<br/>
<br/>
<div class="clockout">
<h2>View Timeclock</h2>
 <button id="mgr"type="submit" class="btn btn-default">View Timeclock History</button><br/>
<div id="mgrclock">
<h3>Individual Timeclock</h3>
<span>Manager would be able to view their own clock in/clock out here</span>
<br/>
<br/>
 <button id="emp" type="submit" class="btn btn-default">Employee Timeclock</button><br/>
</div>
<div id="empclock">
<h3>Employee Timeclock </h3>
<span>Manager would be able to view their employees clock in/clock out here</span>
</div>
</div>

<br/>
<div id="form-grid">
<div class="form-container">
 <h2 id = "message">View Individual Employee Request</h2>
 <br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" id="form">
<form id = "singleReq" action = "" method="get">
  <div class="form-group">
  <br/>
    <label for="username">Enter Employee Username, First Name or Last Name:</label>
    <input id="searchemp" type="text" class="form-control" >
  </div>
  <button id ="single" type="submit" class="btn btn-default">Search</button>
<br/>
<br/>
</form>
<button id ="multi" type="submit" class="btn btn-default">View Multiple Records</button>
<br/>

<form id = "multiReq">
  <div class="form-group">
  <br/>
  <span>Where Records for employees would appear</span>
  </div>
  <div class="form-group"></div>
   <div class="form-group"></div>
  <div class="checkbox"></div>
  <button id ="back" type="submit" class="btn btn-default">View Individual Record</button>
<br/>
<br/>
</form>
<br/>
</div>
<div class="col-md-4"></div>
</div>
</div>
</div>

<br/>
<br/>
<div class="form-container">
 <h2 id = "message">Update Employee Information</h2>
 <br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" id="form">
 
<form id = "updateSingle" action = "" method="get">
  <div class="form-group">
  <br/>
    <label for="username">Email:</label>
    <input id="searchemp" type="text" class="form-control" >
  </div>
  <div class="form-group">
  <br/>
    <label for="username">Employee First Name:</label>
    <input type="text" class="form-control" id="fname"  name="userName">
  </div>
  <div class="form-group">
  <br/>
    <label for="username">Employee Last Name:</label>
    <input type="text" class="form-control" id="lname"  name="userName">
  </div>
  <div class="form-group">
  <br/>
    <label for="username">Password:</label>
    <input type="text" class="form-control" id="email"  name="userName">
  </div>
  <div class="form-group">
  <br/>
    <label for="username">Employee Username:</label>
    <input type="text" class="form-control" id="email"  name="userName">
  </div>
  <button id ="single" type="submit" class="btn btn-default">Submit</button>
<br/>
<br/>
</form>
<br/>
<br/>
</div>
<div class="col-md-4"></div>
</div>
</div>
</div>
<br/>
<div class="form-container" align="center">
 <h2>Submit a Day Off Request <br/>by Filling out the Form Below:</h2>
 <br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" id="form">
 
<form>
  <div class="form-group">
  <br/>
    <label for="req">Select Type of Request</label>
	<select class="form-control"  id="role">
      <option>Vacation</option>
      <option>Unpaid Personal Day</option>
      <option>Medical Leave</option>
      <option>Military Leave</option>
      <option>Two Week Notice</option>
      <option>Other</option>
  </select>
   </div>
  <div class="form-group">
    <label for="days">Start Date:</label>
    <input class="form-control" rows="5" id="reqeust">
  </div>
  <div class="form-group">
    <label for="days">Return Date:</label>
    <input class="form-control" rows="5" id="reqeust">
 </div>
  <div class="form-group">
    <label for="reason">Reason for Request:</label>
    <textarea class="form-control" rows="5" id="reqeust"></textarea>
  <br/>
  <br>
  <button type="submit" class="btn btn-default">Submit</button>
<br/>
<br/>
</form>
</div>
<div class="col-md-4"></div>
</div>
</div>
</div>  <!-- end of form-grid -->

</body>
<script>
$(document).ready(function(){
	$("#multiReq").hide();
	
	$("#multi").click(function(){
		$("#singleReq").hide();
		$("#single").hide();
		$("#multi").hide();
		$("#multiReq").show();
		$("#back").show();
		$("#message").text("View Mulitiple Records");	
		
	});
	
});

$(document).ready(function(){
	$("#mgrclock").hide();
	$("#empclock").hide();
	
	$("#mgr").click(function(){
		$("#mgrclock").show();
		
	});
	$("#emp").click(function(){
		$("#mgrclock").hide();
		$("#empclock").show();
		$("#mgr").text("Return to Timeclock History");
		
	});
		
	$("#mgr").click(function(){
		$("#mgr").text("View Timeclock History");
		$("#empclock").hide();
		
	});
	
});



</script>
</html>