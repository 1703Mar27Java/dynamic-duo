<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p id="requests"></p>
	${requests}
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
	$("#requests").text("hello");
	//var requestID = "${Request_ID}";
});
</script>
</html>
