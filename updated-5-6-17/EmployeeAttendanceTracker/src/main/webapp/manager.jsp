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
<div class="container">
  <button type="submit" class="btn btn-default">View Timeclock History</button><br/>
<span>Manager would be able to view their own clock in/clock out here</span>
</div>
<br/>
<div class="container">
  <button type="submit" class="btn btn-default">View Employee Timeclock History</button><br/>
<span>Manager would be able to view their employees clock in/clock out here</span>
</div>

<div id="form-grid">
<div class="form-container">
 <h2>View A Single Request Record</h2>
 <br/>
<div class="row">

<div class="col-md-4"></div>
<div class="col-md-4" id="form">
<form>
  <div class="form-group">
  <br/>
    <label for="username">Input Employee Last Name:</label>
    <input type="text" class="form-control" id="email">
  </div>
  <button type="submit" class="btn btn-default">Search</button>
<br/>
<br/>
</form>
<br/>
<div class="col-md-4"></div>
</div>
</div><!-- end of single request record form -->
<br/>

<div class="form-container">
 <h2>View Multiple Request Records</h2>
 <br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" id="form"> 
<form>
  <div class="form-group">
  <br/>  
  </div>
  <button type="submit" class="btn btn-default">Display Records</button>
<br/>
<br/>
</form>
<br/>
<div class="col-md-4"></div>
</div>
</div><!-- end multiple records form -->
<br/>

<div class="form-container">
 <h2>View A Single Request Record</h2>
 <br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" id="form">
<form>
  <div class="form-group">
  <br/>
    <label for="username">Input Employee Last Name:</label>
    <input type="text" class="form-control" id="email">
  </div>
  <button type="submit" class="btn btn-default">Search</button>
<br/>
<br/>
</form>
<br/>
<div class="col-md-4"></div>
</div>
</div><!-- end of single request record form -->


<div class="form-container">
 <h2>View A Single Request Record</h2>
 <br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" id="form">
<form>
  <div class="form-group">
  <br/>
    <label for="username">Input Employee Last Name:</label>
    <input type="text" class="form-control" id="email">
  </div>
  <button type="submit" class="btn btn-default">Search</button>
<br/>
<br/>
</form>
<br/>
<div class="col-md-4"></div>
</div>
</div><!-- end of single request record form -->

</div><!-- end of form-grid -->




</div><!-- end of container div for entire page -->
</body>
</html>