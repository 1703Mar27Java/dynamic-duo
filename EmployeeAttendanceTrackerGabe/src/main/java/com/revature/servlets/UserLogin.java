package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.UserBean;
import com.revature.beans.UserRoleBean;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserRoleDaoImpl;
import com.revature.dao.UserRolesDaoImpl;
import com.revature.domain.UserRoles;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class User
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLogin() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dataType = "";
		
		/*PrintWriter out = resp.getWriter();
		out.println("<p>did the post</p>");
		out.println("<a href=\"homePage.html\">go home</>");
		String n1 = req.getParameter("un");
		String n2 = req.getParameter("pw");
		
		out.println("<p>Hello: "+n1+"</p>");*/
            
		/*bankAccount = bankDao.retrieveAccountById(userID);
    	System.out.println(bankAccount);*/
		
		PrintWriter out = response.getWriter();
		String un = request.getParameter("userName");
		String pw = request.getParameter("password");
            
        /*forward*/
    	if (con != null){
			out.println("Connected");
			 UserDaoImpl userDao = new UserDaoImpl();
             UserBean user = userDao.retrieveUserByLoginInfo(un, pw);
                
                //see if username and password are right
                if (user != null){
                	int userID = user.getUserID();
                	String userName = user.getUserName();
                	String password = user.getPassword();
	            
                	//req.setAttribute("userName", userName)
		             
		            HttpSession session = request.getSession(); 
		            int roleID = user.getUserRoleID();
			    	 
		             session.setAttribute("userName", user.getUserName());
		             session.setAttribute("password", user.getPassword());
		             session.setAttribute("firstName", user.getFirstName());
		             session.setAttribute("lastName", user.getLastName());
		             session.setAttribute("email", user.getEmailAddress());
		             session.setAttribute("id", user.getUserID());
                	
                	/*RequestDispatcher rd = req.getRequestDispatcher("mainPage.jsp");
                	rd.forward(req, resp);*/
	                
	                UserRoleDaoImpl userRoleDao = new UserRoleDaoImpl();       
		            UserRoleBean userRole = userRoleDao.retrieveUserRoleByID(roleID);
		         
		            //if user role it is found
		            if (userRole != null){
		            	out.println("Not null");
		            	session.setAttribute("userRole", userRole.getUrRole());
		            	
		            	//if user is a manager, load current requests
		            }
	                
	                out.println("logged in");
		             
		            try {
						con.close();
						response.sendRedirect("loggedIn.jsp");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
    	}
    	else{
    		out.println("Failed to connect");
    	}
	}
}