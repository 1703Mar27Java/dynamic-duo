package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.UserBean;
import com.revature.beans.UserRoleBean;
import com.revature.util.ConnectionUtil;

public class UserRoleDaoImpl implements UserRoleDao{

	@Override
	public int getCurrentUserID() {
		int currentUserRoleID = 0;	//this will default to zero if nothing happens
		
		try(Connection con = ConnectionUtil.getConnection()){
			//used to call the rowCountRoles(row out number) stored procedure in our ERSProject1.sql file
			PreparedStatement pstmt = null;
			try {
			   String sql = "SELECT UR_ID FROM ERS_USER_ROLES";
			   pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				//this is a slow way of having the returned userRoleID that of the last one created. This is
				//necessary for mapping the UR_ID to the created user
				while(rs.next()){
					currentUserRoleID = rs.getInt("UR_ID");
				}
			}
			catch (SQLException e) {
			  e.printStackTrace();
			}
		
			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}

		return currentUserRoleID;

	}
	
	public UserRoleBean retrieveUserRoleByID(int ur_id) {
		PreparedStatement pstmt = null;
		UserRoleBean userRole = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE UR_ID = " + ur_id;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int urid = rs.getInt("UR_ID");
				String ur_role = rs.getString("UR_ROLE");
				userRole = new UserRoleBean(ur_role);
				userRole.setUrID(urid);
				break;
			}
			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		}
		return userRole;
	}

	@Override
	public List<UserBean> retrieveEmployees(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> retrieveManagers(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserRole(UserBean usr, String role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserID(int id) {
		// TODO Auto-generated method stub
	}

}
