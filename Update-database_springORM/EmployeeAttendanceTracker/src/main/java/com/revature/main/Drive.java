package com.revature.main;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.UserRole;
import com.revature.beans.User;
import com.revature.dao.Dao;

public class Drive {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Dao dao = (Dao) ac.getBean("myDao");
		
	/*	UserRole userrole = new UserRole(0,"Employee");
		Users users = new Users("Fred","Flinstone","YabbaDabbaDoo","test1","rocking@bedrock.com");
		
		dao.createUserRole(userrole);
		dao.createUsers(users);
		
		
		System.out.println(users);
		System.out.println(userrole);*/
		
		ac.close();
	}

}
