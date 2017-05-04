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
import com.revature.dao.UserDaoImpl;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class User
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLogin() {
        // TODO Auto-generated constructor stub
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
				             
				            /*HttpSession session = request.getSession(); 
			                session.setAttribute("userId", Integer.toString(userID));
			                session.setAttribute("userName", userName);
			                session.setAttribute("password", password);*/
		                	
		                	/*RequestDispatcher rd = req.getRequestDispatcher("mainPage.jsp");
		                	rd.forward(req, resp);*/
			                
			                out.println("logged in");
				             
				            try {
								con.close();
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
