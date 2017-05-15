<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<title>View Employees</title>
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
		<br /> <br /> <br />

	<table class = "outer" id = "empsAndReqs" style="height: 200px; max-height: 200px; width: 100%;">
			<tr>
				<td colspan = "3">Employees</td>
			</tr>
			<tr>
			<td colspan = "3">
				<table id ="table" class = "inner" style="height: 200px; max-height: 100%; overflow-y: scroll; width: 100%;">
				
				</table>
				
			</td>
		</tr>	
	</table>
	</div>
</body>
<script>
$(document).ready(function(){
	
	$("#dialog").hide();
	$("#approvedDeclined").hide();
	
	var userName = "${username}";
	userName = userName.replace('[','');
	userName = userName.replace(']','');
	var firstName = "${firstName}";
	firstName = firstName.replace('[','');
	firstName = firstName.replace(']','');
	var  lastName = "${lastName}";
	lastName = lastName.replace('[', '');
	lastName = lastName.replace(']', '');
	var userID = "${userID}";
	userID = userID.replace('[', '');
	userID = userID.replace(']', '');
	var email = "${email}";
	email = email.replace('[', '');
	email = email.replace(']', '');
	
	var parser = "";
	
	var un = userName.split(",");
	var fName = firstName.split(",");
	var lName = lastName.split(",");
	var uID = userID.split(",");
	var em = email.split(",");
	
	var index = 0;
	
	$("#table").html("<tr id=" + "row" + ">" + "<th>" + "Employee ID" + "<th>" + "Employee Name" + "</th>" + "<th>" + "First Name" + "</th>" + "<th>" + "Last Name" + "</th>" + "<th>" + "Email Address" + "</th>"+ "</tr>");
	for (var i = 0; i < uID.length; i++){
		
		var parser = "<td class="+"format"+">"+uID[i]+"</td>"
		+"<td class="+"format"+">"+un[i]+"</td>"
		+"<td class="+"format"+">"+fName[i]+"</td>"
		+"<td class="+"format"+">"+lName[i]+"</td>"
		+"<td class="+"format"+">"+em[i]+"</td>";
		
		$("#table").html($("#table").html() + "<tr id ="+"reqRow" +index+" class="+"format"+">"+parser+"</tr>");
		
		index++;
	}
	$("td").css("text-align", "center");
	
});
</script>
</html>
