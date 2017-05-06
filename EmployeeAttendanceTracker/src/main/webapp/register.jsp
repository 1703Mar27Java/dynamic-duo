<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title> 
	<%@page import="com.revature.dao.UserDaoImpl"%> 
	<%@page import="one.to.many.ERS_USERS"%> 
	<%@page import="com.revature.dao.util.HibernateUtil"%> 
	<%@page import="org.hibernate.Session"%>
    <jsp:useBean id="obj" class="one.to.many.ERS_USERS">  
    </jsp:useBean>  
    <jsp:setProperty property="*" name="obj"/>  
      
    <%  
    
    	String un = "BobBigboys";
    	String pw = "password";
    	UserDaoImpl usrDao = new UserDaoImpl();
    	ERS_USERS usr = usrDao.retrieveUserByLoginInfo(un, pw);
    	if(usr != null)  
    		out.print("You are successfully registered");
    	else{
    		out.print("Try again, shmuck");
    	}
    %>  
</head>
<body>

</body>
</html>