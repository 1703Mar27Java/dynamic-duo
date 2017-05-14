<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Username: ${username}</p>
	<p>First Name: ${firstName}</p>
	<p>Last Name: ${lastName}</p>
	<p>User ID: ${userID}</p>
	<p>Email Address: ${email}</p>
	
<table>
<tr>
<c:forEach items="${employees}" var="userForm">
		<td></td>
</c:forEach>
</tr>
</table>

</body>
</html>
