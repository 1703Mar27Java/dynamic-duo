package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.EmpRequests;
import com.revature.beans.RequestType;
import com.revature.beans.UserBean;

public class RequestDaoImpl implements RequestDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<EmpRequests> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	public void makeRequest(EmpRequests req) {
		// TODO Auto-generated method stub

	}

	public void makeRequestType(RequestType reqTyp) {
		// TODO Auto-generated method stub

	}

	public EmpRequests retrieveRequestsByLastName(String lastName) {
		return null;
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
			
		System.out.println(s.isConnected());
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
