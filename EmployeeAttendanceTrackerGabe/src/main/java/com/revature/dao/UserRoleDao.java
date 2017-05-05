package com.revature.dao;

import java.util.List;

import com.revature.beans.UserBean;
import com.revature.beans.UserRoleBean;

public interface UserRoleDao {
	public int getCurrentUserID();
	public UserRoleBean retrieveUserRoleByID(int ur_id);
	public List<UserBean> retrieveEmployees(int userId);
	public List<UserBean> retrieveManagers(int userId);
	public void updateUserRole(UserBean usr, String role);
	public void deleteUserID(int id);
}
