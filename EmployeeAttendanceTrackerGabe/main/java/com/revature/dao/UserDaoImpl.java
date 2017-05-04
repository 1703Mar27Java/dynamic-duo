package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.beans.UserBean;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	public UserDaoImpl(){
		
	}

	public void createUser(UserBean user) {
		try(Connection con = ConnectionUtil.getConnection()){
			//we're autogenerating out pks u in the database because we're not barbarians
			String userName = user.getUserName();
			String passWord = user.getPassword();
			
			String sql = "INSERT INTO ERS_USERS (U_USERNAME, U_PASSWORD) VALUES ('"+userName+"', '"+passWord+"')";
			
			Statement statement = con.createStatement();	//this is precompiled
			int numRowsAffected = statement.executeUpdate(sql);	//this argument is not precompiled as a paramater
			System.out.println("hi");							//use prepared statements to prevent sql injections by users
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public UserBean retrieveUserByLoginInfo(String un, String pw) {
		PreparedStatement pstmt = null;
		UserBean user = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_USERS WHERE U_USERNAME = '" + un +"' AND U_PASSWORD = '" + pw +"'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("U_ID");
				user = new UserBean(un, pw);
				user.setUserID(id);
				break;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
		return user;
	}

	public UserBean retrieveUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserBean> retrieveAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	public void createUserPS(UserBean user) {
		// TODO Auto-generated method stub

	}

}
