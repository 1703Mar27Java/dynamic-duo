package com.revature.dao;

import java.util.List;
import one.to.many.ERS_USERS;

public interface UserDao {
	
	public void createUser(ERS_USERS user);
	public ERS_USERS retrieveUserByLoginInfo(String un, String pw);
	public ERS_USERS retrieveUserById(int userId);
	public List<ERS_USERS> retrieveAllUser();
	public void updateUser(ERS_USERS user);
	public void deleteUser(int id);
	public void createUserPS(ERS_USERS user);
}
