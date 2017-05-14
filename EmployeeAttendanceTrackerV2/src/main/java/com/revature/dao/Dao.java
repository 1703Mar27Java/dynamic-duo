package com.revature.dao;

import java.util.List;

import com.revature.beans.*;


public interface Dao {

	
	
	public void createUsers(User user);	
	
	public void createUserRole(UserRole userrole);
	
	public void createRequest(EmpRequests emprequests);
	
	public List<AttendanceHistory> getAttendanceHistory();
	
	public List<RequestHistory> getRequestHistory();
	
	public List<EmpRequests> emprequests();
	
	public List<User> getUser();
	
	public List<UserRole> getUserrole();
	
	public void updateUsers(User user);
	
	public void updateEmpRequests(EmpRequests emprequests);
	
	
	
	
	
	
	
	
	
}
