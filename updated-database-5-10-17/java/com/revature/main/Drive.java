package com.revature.main;

import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;
import com.revature.dao.Dao;

public class Drive {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Dao dao = (Dao) ac.getBean("myDao");
		
	//	SimpleDateFormat  d = new SimpleDateFormat("MM/DD/YYYY");
		
		//UserRole userrole = new UserRole("Employee");
		//User user = new User("Fred","Flinstone","YabbaDabbaDoo","test1","rocking@bedrock.com");
	//	EmpRequests empRequests = new EmpRequests("Vacation", 10-05-17, 10-06-17,"I want to go home to see my momma");
		
		//dao.createUserRole(userrole);
		//dao.createUsers(user);
		
	//	List<UserRole> userRole = dao.getUserRole();
		//System.out.println(user);
		//System.out.println(userrole);
	//	System.out.println(userRole);
		List <User> u = dao.getUser();
		System.out.println(u);
		
		ac.close();
	}

}
