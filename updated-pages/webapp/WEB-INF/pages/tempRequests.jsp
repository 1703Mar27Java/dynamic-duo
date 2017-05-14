<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>	
		
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />
<spring:url value="/resources/js/eat.js" var="eatJs" />
<script src="${eatJs}"></script>
   
<!-- <style>
   	 /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
   	 body {
   	 	background-color: lightblue
   	 }
   	 .row.content {
   	 	height: 100px
   	 }
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
   	
   	#dialog {
   		background-color: white;
   		width: 50%;
   		height: 10%;
   		margin: 0% 0% 0% 25%;
   	} 
   	
   	#welcome {
   		background-color: lightblue;
   		width: 50%;
   		height: 10%;
   		margin: 0% 0% 0% 25%;
   	}
   	
   	#innerDialog{
   		padding:1% 1% 1% 1%;
   	}
   	
   	#approvedDeclined{
   		background-color: white;
   		color: red;
   		width: 20%;
   		height: 15%;
   		margin: 0% 0% 0% 25%;
   		text-align: center;
   		font-size:16px;
   	}
    </style>
 -->
 
	 
<title>Reimbursements</title>
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
	</div>
	
	<div class="container" align="center">
	<h2>Employee Reimbursement Requests</h2>
	<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-6">
	
	<table class = "outer" id = "empsAndReqs">
			<tr>
			<td colspan = "3">
				<table id ="table" class = "inner" style="height: 200px; max-height: 200px; overflow-y: scroll;">
				
				</table>
				
			</td>
		</tr>
		<tr>
			<td colspan = "3">Reimbursement Requests</td>
		</tr>
		<tr>
			<td colspan="3">
			<table id = "requ" class = "inner" style="height: 100px; overflow-y: scroll;">
				
			</table>
			</td>
		</tr>
	</table>	
	</div>
	</div>
	<div class="col-md-2"></div>
	</div>
	
</body>
<script>

$(document).ready(function(){
	var requestID = "${Request_ID}";
	requestID = requestID.replace('[','');
	requestID = requestID.replace(']','');
	var description = "${Description}";
	description = description.replace('[','');
	description = description.replace(']','');
	var  endDate = "${End_date}";
	endDate = endDate.replace('[', '');
	endDate = endDate.replace(']', '');
	var requestName = "${Request_Name}";
	requestName = requestName.replace('[', '');
	requestName = requestName.replace(']', '');
	var startDate = "${Start_Date}";
	startDate = startDate.replace('[', '');
	startDate = startDate.replace(']', '');
	var resolved = "${Resolved}";
	resolved = resolved.replace(']','');
	resolved = resolved.replace(']','');
	var	requestType = "${Request_Type}";
	requestType = requestType.replace('[', '');
	requestType = requestType.replace(']', '');
	var user = "${User}";
	user = user.replace('[', '');
	user = user.replace(']', '');
	
	var parser = "";
	
	var desc = description.split(",");
	//desc.replace('[','');
	var reqID = requestID.split(",");
	var eDate = endDate.split(",");
	var reqName = requestName.split(",");
	var staDate = startDate.split(",");
	var res = resolved.split(",");
	var type = requestType.split(",");
	var usr = user.split(",");
	
	var index = 0;
	
	$("#table").html("<tr>" + "<th>" + "Request ID" + "<th>" + "Request Name" + "</th>" + "<th>" + "Description" + "</th>" + "<th>" + "Begin Date" + "</th>" + "<th>" + "End Date" + "</th>" + "<th>" + "Request Type" + "</th>" + "<th>" + "Resolved" + "</th>" + "<th>" + "User" + "</th>" + "</tr>");
	for (var i = 0; i < desc.length; i++){
		
		var parser = "<td class="+"format"+">"+reqID[i]+"</td>"
		+"<td class="+"format"+">"+reqName[i]+"</td>"
		+"<td class="+"format"+">"+desc[i]+"</td>"
		+"<td class="+"format"+">"+staDate[i]+"</td>"
		+"<td class="+"format"+">"+eDate[i]+"</td>"
		+"<td class="+"format"+">"+type[i]+"</td>"
		+"<td class="+"format"+">"+res[i]+"</td>"
		+"<td class="+"format"+">"+usr[i]+"</td>";
		
		$("#table").html($("#table").html() + "<tr id ="+"reqRow" +index+" class="+"format"+">"+parser+"</tr>");
		
		index++;
	}
	
	for (var i = 0; i < desc.length; i++){
		alert(res[i]);
		if (res[i].search("Approved")){
			$("#reqRow" +i).css("background-color", "green");
			alert("green");
		}
		else if (res[i].search("Denied")){
			alert(res[i]);
			$("#reqRow" +i).css("background-color", "red");
		}
		else if (res[i].search("Pending")){
			$("#reqRow" +i).css("background-color", "white");
		}
		$("#reqRow" +i).click(function(){
			alert($(this).html());
			var n = ($(this).html()).indexOf("rID=");
			var temp = ($(this).html()).charAt(n+4);
			alert(($(this).html()).charAt(n+4));
			reiId = temp;
			
			$.post("GetRequests", {
				id: temp,
			},
			function(data, status){
				//alert(status + data);
				$("#innerDialog").text(data);
				$("#dialog").fadeIn(1000);
			});
		});
	}
	
	$("#description").text(desc[1]);
	
});

</script>
</html>
