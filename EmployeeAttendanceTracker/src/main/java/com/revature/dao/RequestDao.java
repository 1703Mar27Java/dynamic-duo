package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.revature.beans.EmpRequests;
import com.revature.beans.RequestType;



public interface RequestDao {
	public void setSessionFactory(SessionFactory sessionFactory);
	
	public List<EmpRequests> getAllRequests();
	public void makeRequest(EmpRequests req);
	public void makeRequestType(RequestType reqTyp);
	public EmpRequests retrieveRequestsByLastName(String lastName);
	public List<EmpRequests> retrieveRequestByEmpID(int id);
	public EmpRequests retrieveSingleRequest(int id);
	public void changeRequestStatus(int id, String choice);
}
