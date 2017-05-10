package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.revature.beans.UserRole;
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

}
