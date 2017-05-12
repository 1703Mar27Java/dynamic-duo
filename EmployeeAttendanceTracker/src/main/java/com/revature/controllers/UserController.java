package com.revature.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.UserBean;
import com.revature.beans.UserRoleBean;
import com.revature.dao.DaoImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	DaoImpl userDao;
	
	@RequestMapping(value="/{firstName}/{lastName}",method=RequestMethod.GET)
	public String getPerson(@PathVariable String firstName, @PathVariable String lastName, Model m) {
		m.addAttribute("firstName",firstName);
		m.addAttribute("lastName",lastName);
		return "index";
	}
	
	//home page
	@RequestMapping(value="/log",method=RequestMethod.GET)
	public String enterPersonInfo(Map<String, Object> m){
		UserBean userForm = new UserBean();
		m.put("userForm", userForm);
		//m.addAttribute("person",new UserBean());
		return "index";
	}
	
	//about
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String getAbout(Model m){
		//m.addAttribute("person",new UserBean());
		return "about";
	}
	
	//contact
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String getContact(Model m){
		//m.addAttribute("person",new UserBean());
		return "contact";
	}
	
	//tech
	@RequestMapping(value="/tech",method=RequestMethod.GET)
	public String getTech(Model m){
		//m.addAttribute("person",new UserBean());
		return "tech";
	}
	
	//register
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("userForm") UserBean userForm, BindingResult br, Map<String, Object> m/*,  @RequestParam(value="userName", required=false) String userName, 
			@RequestParam(value="password", required=false) String password*/){
		
		//this is where the db checking will go perhaps
				if (br.hasErrors()){
					Object errors = br.getAllErrors();
					m.put("errors",errors);
					return "index";
				}else{
					if (!(userForm.getPassword()).equals(userForm.getPassword2())){
						m.put("errors", "Passwords have to match");
						return "index";
					}
					else{
						m.put("userName", userForm.getUserName());
						m.put("password", userForm.getPassword());
					}
				}
				//create (for a login) a loginService class 
				//call authUser 
				return "newUser";
	}
	
	//Capitol building singalong
	//register
		@RequestMapping(value="/newUser",method=RequestMethod.POST)
		public String setNewUser(@Valid @ModelAttribute("userForm") UserBean userForm, BindingResult br, Map<String, Object> m/*,  @RequestParam(value="userName", required=false) String userName, 
				@RequestParam(value="password", required=false) String password*/){
			
			//this is where the db checking will go perhaps
					if (br.hasErrors()){
						Object errors = br.getAllErrors();
						m.put("errors",errors);
						return "index";
					}else{
					
						m.put("lname", userForm.getLastName());
						m.put("fname", userForm.getFirstName());
						m.put("email", userForm.getEmailAddress());
						m.put("userRole", userForm.getUserRole());
						
						if ((userForm.getUserRole()).equals("Employee")){
							return "emp";
						}
						else if (userForm.getUserRole().equals("Manager")){
							return "manager";
						}
						
					}
					//create (for a login) a loginService class 
					//call authUser 
					return "newUser";
		}
		
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("userForm") UserBean userForm, BindingResult br, Map<String, Object> m/*,  @RequestParam(value="userName", required=false) String userName, 
							@RequestParam(value="password", required=false) String password*/){
		
		UserBean user = userDao.retrieveUserByLoginInfo(userForm.getUserName(), userForm.getPassword());
		
		if (user != null){
			return "emp";
		}
		else{
			return "index";
		}
		//this is where the db checking will go perhaps
		/*if (br.hasErrors()){
			Object errors = br.getAllErrors();
			m.put("errors",errors);
			return "index";
		}else{
			m.put("userName", userForm.getUserName());
			m.put("password", userForm.getPassword());
		}*/
		//create (for a login) a loginService class 
		//call authUser 
	}
}
