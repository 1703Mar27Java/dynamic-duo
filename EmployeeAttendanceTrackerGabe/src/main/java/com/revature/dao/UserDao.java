package com.revature.dao;

import java.util.List;

import com.revature.beans.UserBean;

public interface UserDao {
	
	public void createUser(UserBean user);
	public UserBean retrieveUserByLoginInfo(String un, String pw);
	public UserBean retrieveUserById(int userId);
	public List<UserBean> retrieveAllUser();
	public void updateUser(UserBean user);
	public void deleteUser(int id);
	public void createUserPS(UserBean user);
}
