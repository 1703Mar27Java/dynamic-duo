package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.revature.dao.util.HibernateUtil;
import com.revature.util.ConnectionUtil;

import one.to.many.ERS_USERS;

public class UserDaoImpl implements UserDao {
	
	public UserDaoImpl(){
		
	}

	public void createUser(ERS_USERS user) {
		try(Connection con = ConnectionUtil.getConnection()){
			Session sesh = HibernateUtil.getSession();
			//we're autogenerating out pks u in the database because we're not barbarians
			String userName = user.getUserName();
			String passWord = user.getPassword();
			
			String sql = "INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD) VALUES ('"+userName+"', '"+passWord+"')";
			
			Statement statement = con.createStatement();	//this is precompiled
			int numRowsAffected = statement.executeUpdate(sql);	//this argument is not precompiled as a paramater
			System.out.println("hi");							//use prepared statements to prevent sql injections by users
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	//hibernate
	public ERS_USERS retrieveUserByLoginInfo(String un, String pw) {
		
		ERS_USERS user = null;
		List<ERS_USERS> users = new ArrayList<ERS_USERS>();
		Session sesh = HibernateUtil.getSession();
		
		System.out.println(sesh.isConnected());
		if (sesh.isConnected()){
			System.out.println("connected");
			users = sesh.createQuery("from ERS_USERS where u_username = :u_username").setString("u_username", un).list();
		}
		else{
			System.out.println("Not connected");
		}
						
		
		if(!users.isEmpty()){
			user = users.get(0);
		}
		
		/* commit and close session */
		
		sesh.close();
		
		return user;
	}

	public ERS_USERS retrieveUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ERS_USERS> retrieveAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUser(ERS_USERS user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	public void createUserPS(ERS_USERS user) {
		// TODO Auto-generated method stub

	}

}
