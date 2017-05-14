package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.AttendanceHistory;
import com.revature.beans.EmpRequests;
import com.revature.beans.RequestType;

public class AttendanceDaoImpl implements AttendanceDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<AttendanceHistory> getAllAttendHistory() {
		Session s;
		try {
		    s = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    s = sessionFactory.openSession();
		}
		
		List<AttendanceHistory> history = new ArrayList<AttendanceHistory>();
		
		if (s.isConnected()){
			System.out.println("connected");
			history = s.createQuery("from AttendanceHistory").list();      
		}
		else{
			System.out.println("Not connected");
		}
			
		return history;
	}

	@Override
	public List<AttendanceHistory> getAttendHistoryByUser(int id) {
		Session s;
		try {
		    s = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    s = sessionFactory.openSession();
		}
		
		List<AttendanceHistory> history = new ArrayList<AttendanceHistory>();
		
		if (s.isConnected()){
			System.out.println("connected");
			history = s.createQuery("from AttendanceHistory where user = :id").setInteger("id", id).list();      
		}
		else{
			System.out.println("Not connected");
		}
			
		return history;
	}

	@Override
	public void clockInAndOut(AttendanceHistory hist) {
		// TODO Auto-generated method stub
		
	}
}
