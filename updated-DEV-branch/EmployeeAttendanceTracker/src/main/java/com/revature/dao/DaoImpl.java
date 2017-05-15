package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.revature.beans.UserRoleBean;
import com.revature.beans.UserBean;

@Transactional
public class DaoImpl implements Dao {
	
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory mysessionFactory){
		System.out.print("inside setter");
		this.sessionFactory = mysessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRoleBean> getUserrole() {
		/*Session s = sessionFactory.getCurrentSession();
		List<UserRoleBean> userrole = new ArrayList<UserRoleBean>();
		userrole = s.createQuery("from UserRole").list();*/
		return null;//userrole;
	}
	

	public void createUsers(UserBean user) {
		Session s;
		try {
		    s = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    s = sessionFactory.openSession();
		}
		
		if (s.isConnected()){
			System.out.println("connected");
			s.beginTransaction();
			s.saveOrUpdate(user);
			s.save(user);
			s.getTransaction().commit();
			s.close();
		}
		else{
			System.out.println("Not connected");
		}
	}


	public void createUserRole(UserRoleBean userrole) {
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		s.save(userrole);
		s.getTransaction().commit();
		s.close();
	}
	
	//hibernate
	public UserBean retrieveUserByLoginInfo(String un, String pw) {	
		Session s;
		try {
		    s = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    s = sessionFactory.openSession();
		}
		
		UserBean user = null;
		
		List<UserBean> users = new ArrayList<UserBean>();
			
		System.out.println(s.isConnected());
		if (s.isConnected()){
			System.out.println("connected");
			users = s.createQuery("from UserBean where userName = :u_username AND password = :u_password").setString("u_username", un).setString("u_password", pw).list();      
		}
		else{
			System.out.println("Not connected");
		}
							
			
		if(!users.isEmpty()){
			user = users.get(0);
		}
			
		/* commit and close session */
			
		return user;
	}

		public UserBean retrieveUserById(int userId) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<UserBean> retrieveAllUser() {
			Session s;
			try {
			    s = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
			    s = sessionFactory.openSession();
			}
			
			List<UserBean> users = new ArrayList<UserBean>();
				
			System.out.println(s.isConnected());
			if (s.isConnected()){
				System.out.println("connected");
				users = s.createQuery("from UserBean").list();
			}
			else{
				System.out.println("Not connected");
			}
				
			
			/* commit and close session */
				
			return users;

		}

		public void updateUser(UserBean user) {
			// TODO Auto-generated method stub

		}

		public void deleteUser(int id) {
			// TODO Auto-generated method stub

		}

		public void createUserPS(UserBean user) {
			// TODO Auto-generated method stub

		}

}

//if you have a server running but you can't find it:
//netstat -a -o -n
//find correct local address (look for port number), and note the running instance's pid
//taskkill /f /pid <pid number> 

