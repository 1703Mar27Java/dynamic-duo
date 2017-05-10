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
<title>Employee</title>
</head>
<body>
<div class="container" align="center">
<h1><strong>Employee Attendance Tracker</strong></h1>
<h3><strong>Employees</strong></h3>
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

<div class="container">
  <button type="submit" class="btn btn-default">View Timeclock History</button>
<p>Employee  info would go here to check out their clock in/clock out </p>
<h3>Welcome ${userForm.userName}! You have logged in successfully.</h3>


</div>


<div class="form-container">
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


</div>
</body>
</html>