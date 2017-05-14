package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;

import com.revature.beans.EmpRequests;
import com.revature.beans.RequestType;
import com.revature.beans.UserBean;

public class RequestDaoImpl implements RequestDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<EmpRequests> getAllRequests() {
		//open session
				Session s;
				try {
				    s = sessionFactory.getCurrentSession();
				} catch (HibernateException e) {
				    s = sessionFactory.openSession();
				}
				
				List<EmpRequests> requests = new ArrayList<EmpRequests>();
				
				if (s.isConnected()){
					System.out.println("connected");
					requests = s.createQuery("from EmpRequests").list();      
				}
				else{
					System.out.println("Not connected");
				}
					
				return requests;
	}

	public void makeRequest(EmpRequests req) {
		Session s;
		try {
			s = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			s = sessionFactory.openSession();
		}
		
		if (s.isConnected()){
			s.saveOrUpdate(req);
			s.save(req);
		}
	}

	public void makeRequestType(RequestType reqTyp) {
		// TODO Auto-generated method stub

	}

	public EmpRequests retrieveRequestsByLastName(String lastName) {
		return null;
	}
	
	public void changeRequestStatus(int id, String choice){
		//open session
		Session s;
		try {
			s = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			s = sessionFactory.openSession();
		}
		
		EmpRequests req = null;
		
		List<EmpRequests> requests = new ArrayList<EmpRequests>();
			
		System.out.println(s.isConnected());
		if (s.isConnected()){
			System.out.println("connected");
			requests = s.createQuery("from EmpRequests where uID = :id").setInteger("id", id).list();      
		}
		else{
			System.out.println("Not connected");
		}
		
		if(!requests.isEmpty()){
			req = requests.get(0);
		}
				
	}

	public  List<EmpRequests> retrieveRequestByEmpID(int id) {
		
		//open session
		Session s;
		try {
		    s = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    s = sessionFactory.openSession();
		}
		
		List<EmpRequests> requests = new ArrayList<EmpRequests>();
		
		if (s.isConnected()){
			System.out.println("connected");
			requests = s.createQuery("from EmpRequests where uID = :id").setInteger("id", id).list();      
		}
		else{
			System.out.println("Not connected");
		}
			
		return requests;
	}

	public EmpRequests retrieveSingleRequest(int id) {
		//open session
				Session s;
				try {
				    s = sessionFactory.getCurrentSession();
				} catch (HibernateException e) {
				    s = sessionFactory.openSession();
				}
				
				EmpRequests req = null;
				
				List<EmpRequests> requests = new ArrayList<EmpRequests>();
					
				System.out.println(s.isConnected());
				if (s.isConnected()){
					System.out.println("connected");
					requests = s.createQuery("from EmpRequests where uID = :id").setInteger("id", id).list();      
				}
				else{
					System.out.println("Not connected");
				}
				
				if(!requests.isEmpty()){
					req = requests.get(0);
				}
					
				return req;
	}

}