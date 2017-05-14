package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.revature.beans.UserRole;
import com.revature.beans.AttendanceHistory;
import com.revature.beans.EmpRequests;
import com.revature.beans.RequestHistory;
import com.revature.beans.RequestStatus;
import com.revature.beans.User;

@Transactional
@Repository
public class DaoImpl implements Dao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserrole() {
		Session s = sessionFactory.getCurrentSession();
		List<UserRole> userrole = new ArrayList<UserRole>();
		userrole = s.createQuery("from UserRole").list();
		return userrole;
	}


	@Override
	public void createUsers(User user) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(user);
		s.save(user);
		
	}


	@Override
	public void createUserRole(UserRole userrole) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(userrole);
		s.save(userrole);
	}


	@Override
	public void addStatus(RequestStatus requestStatus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createRequest(EmpRequests empRequests) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<AttendanceHistory> getAttendanceHistory() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RequestHistory> getRequestHistory() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<EmpRequests> getEmpRequests() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RequestStatus> getRequestStatus() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateUsers(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateEmpRequests(EmpRequests emprequests) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateStaus(RequestStatus requestStatus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteEmpRequests(EmpRequests emprequests) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteStatus(RequestStatus requestStatus) {
		// TODO Auto-generated method stub
		
	}

}
