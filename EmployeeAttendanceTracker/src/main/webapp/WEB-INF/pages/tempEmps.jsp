<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employees</title>
</head>
<body>
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
