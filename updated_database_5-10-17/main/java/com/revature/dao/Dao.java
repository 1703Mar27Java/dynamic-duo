package com.revature.dao;

import java.util.List;

import com.revature.beans.*;


public interface Dao {

	public void addStatus(RequestStatus requestStatus);
	
	public void createUsers(User user);	
	
	public void createUserRole(UserRole userrole);
	
	public void createRequest(EmpRequests empRequests);
	
	
	public List<AttendanceHistory> getAttendanceHistory();
	
	public List<RequestHistory> getRequestHistory();
	
	public List<EmpRequests> getEmpRequests();
	
	public List<User> getUser();
	
	public List<UserRole> getUserrole();
	
	public List<RequestStatus> getRequestStatus();
	
	
	public void updateUsers(User user);
	
	public void updateEmpRequests(EmpRequests emprequests);
	
	public void updateStaus(RequestStatus requestStatus);
	
	
	public void deleteUser(User user);
	
	public void deleteEmpRequests(EmpRequests emprequests);
	
	public void deleteStatus(RequestStatus requestStatus);

	
	
	
}