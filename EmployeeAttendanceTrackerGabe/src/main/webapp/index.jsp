<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

<title>Employee Attendance Tracker</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container-fluid">

<h1>Employee Attendance Tracker</h1>

<div class="navbar-header">
<div  class="nav navbar-nav">
<div class="col-md-12">
<ul class="navbar">
	<li class="active"><a href="#">Home</a></li>
	<li><a href="#">Help</a></li>
	<li><a href="#">Contact Us</a></li>
	<li><a href="#">About E.A.T.</a></li>
</ul>
</div>
</div><!--end of nav row-  -->
</div><!-- end of nav div -->
</div><!-- end of container-fluid div -->

<form action="UserLogin" method="post">
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" class="form-control" id="email" name="userName">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd" name="password">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>


</body>
</html>
