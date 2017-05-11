package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.revature.beans.UserRoleBean;
import com.revature.beans.UserBean;

@Transactional
@Repository
public class DaoImpl implements Dao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRoleBean> getUserrole() {
		Session s = sessionFactory.getCurrentSession();
		List<UserRoleBean> userrole = new ArrayList<UserRoleBean>();
		userrole = s.createQuery("from UserRole").list();
		return userrole;
	}
	

	@Override
	public void createUsers(UserBean user) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(user);
		s.save(user);
		
	}


	@Override
	public void createUserRole(UserRoleBean userrole) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(userrole);
		s.save(userrole);
	}
	
	//hibernate
	public UserBean retrieveUserByLoginInfo(String un, String pw) {
			
		Session sesh = sessionFactory.getCurrentSession();
		UserBean user = null;
		List<UserBean> users = new ArrayList<UserBean>();
			
		System.out.println(sesh.isConnected());
		if (sesh.isConnected()){
			System.out.println("connected");
			users = sesh.createQuery("from ERS_USERS where u_username = :u_username").setString("u_username", un).list();
		}
		else{
			System.out.println("Not connected");
		}
							
			
		if(!users.isEmpty()){
			user = users.get(0);
		}
			
		/* commit and close session */
			
		sesh.close();
			
		return user;
	}

		public UserBean retrieveUserById(int userId) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<UserBean> retrieveAllUser() {
			// TODO Auto-generated method stub
			return null;
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

