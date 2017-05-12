<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table id ="table">
	
	</table>
	
	<p id="requests"></p>
	<p id="description"></p>
	<p>Request_ID ${Request_ID}</p>
	<p>Description ${Description}</p>
	<p>End Date ${End_date}</p>
	<p>Request Name ${Request_Name}</p>
	<p>Start_Date ${Start_Date}</p>
	<p>Resolved? ${Resolved}</p>
	<p>Request Type ${Request_Type}</p>
	<p>User ${User}</p>
</body>
<script>

$(document).ready(function(){
	var requestID = "${Request_ID}";
	var description = "${Description}";
	var  endDate = "${EndDate}";
	var requestName = "${Request_Name}";
	var startDate = "${Start_Date}";
	var resolved = "${Resolved}";
	var	requestType = "${Request_Type}";
	var user = "${User}";
	$("#requests").text(requestID[1]);
	
	var parser = "";
	
	var desc = description.split(",");
	var reqID = requestID.split(",");
	var eDate = endDate.split(",");
	var reqName = requestName.split(",");
	var staDate = startDate.split(",");
	var res = resolved.split(",");
	var type = requestType.split(",");
	var usr = user.split(",");
	
	
	for (var i = 0; i < desc.length; i++){
		
		var parser = "<td class="+"format"+">"+desc[i]+"</td>"+"<td class="+"format"+">"+reqID[i]+"</td>"
		+"<td class="+"format"+">"+eDate[i]+"</td>"
		+"<td class="+"format"+">"+reqName[i]+"</td>"
		+"<td class="+"format"+">"+staDate[i]+"</td>"
		+"<td class="+"format"+">"+res[i]+"</td>"
		+"<td class="+"format"+">"+type[i]+"</td>"
		+"<td class="+"format"+">"+usr[i]+"</td>";
		
		$("#table").html($("#table").html() + "<tr>"+parser+"</tr>");
	}
	
	$("#description").text(desc[0]);
	
});

</script>
</html>
