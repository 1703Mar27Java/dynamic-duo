package com.revature.dao;

import java.util.List;

import com.revature.beans.*;


public interface Dao {

	public List<UserRole> getUserrole();

	public void createUsers(User user);
	
	public void createUserRole(UserRole userrole);
	
	
}
