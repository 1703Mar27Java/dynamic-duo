package com.revature.dao;

import java.util.List;

import com.revature.beans.*;


public interface Dao {

	public List<UserRoleBean> getUserrole();

	public void createUsers(UserBean user);
	
	public void createUserRole(UserRoleBean userrole);
	
	public UserBean retrieveUserByLoginInfo(String un, String pw);
	public UserBean retrieveUserById(int userId);
	public List<UserBean> retrieveAllUser();
	public void updateUser(UserBean user);
	public void deleteUser(int id);
	public void createUserPS(UserBean user);
	
}
