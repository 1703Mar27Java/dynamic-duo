package com.revature.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.Dao;

public class Main {

	public static void main(String[]args){
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Dao dao = (Dao) ac.getBean("myDao");
		
		ac.close();
	}
	
	
}


