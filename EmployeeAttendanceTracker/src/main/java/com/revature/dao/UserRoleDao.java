package com.revature.dao;

import java.util.List;
import com.revature.beans.UserRoleBean;

import one.to.many.ERS_USERS;

public interface UserRoleDao {
	public int getCurrentUserID();
	public UserRoleBean retrieveUserRoleByID(int ur_id);
	public List<ERS_USERS> retrieveEmployees(int userId);
	public List<ERS_USERS> retrieveManagers(int userId);
	public void updateUserRole(ERS_USERS usr, String role);
	public void deleteUserID(int id);
}
