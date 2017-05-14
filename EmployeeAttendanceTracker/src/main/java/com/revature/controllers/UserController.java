package com.revature.controllers;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.EmpRequests;
import com.revature.beans.UserBean;
import com.revature.beans.UserRoleBean;
import com.revature.dao.DaoImpl;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import javax.annotation.PostConstruct;

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
		
		EmpRequests requestForm = new EmpRequests();
		m.put("requestForm", requestForm);
		
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
					
						userDao.createUsers(userForm);
						
						m.put("lname", userForm.getLastName());
						m.put("fname", userForm.getFirstName());
						m.put("email", userForm.getEmailAddress());
						m.put("userRole", userForm.getUserRole());
						
						if ((userForm.getUserRole()).getUrRole().equals("Employee")){
							return "emp";
						}
						else if (userForm.getUserRole().getUrRole().equals("Manager")){
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
			int uRole = user.getUserrole().getUrID();
			if (uRole == 2){
				return "emp";
			}
			else if (uRole == 1){
				return "manager";
			}
			else return "index";
		}
		else{
			return "index";
		}
	}
	
	//used for AJAX calls
	// @ResponseBody, not necessary, since class is annotated with @RestController
		// @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
		// @JsonView(Views.Public.class) - Optional, filters json data to display.
		//@JsonView(Views.Public.class)
		@RequestMapping(value = "/employees/all", method=RequestMethod.GET)
		//public @ResponseBody
		public List<UserBean> getSearchResultViaAjax(@Valid @ModelAttribute("userForm") UserBean userForm, BindingResult br, Map<String, Object> m) {

			List<UserBean> result = userDao.retrieveAllUser();
			System.out.println("Result");
			System.out.println(result);

			//AjaxResponseBody will be converted into json format and send back to the request.
			return result;
		}
		
		@RequestMapping(value = "/employees/allTemp", method=RequestMethod.POST)
		//public @ResponseBody
		public String getUsers(@Valid @ModelAttribute("userForm") UserBean userForm, BindingResult br, Model m) {

			List<UserBean> result = userDao.retrieveAllUser();
					
			UserBean bean = result.get(0);
			
			Map<String, String>[] userInfoArr = new HashMap[result.size()];
			
			List<String> userNames = new ArrayList<String>();
			List<String> firstNames = new ArrayList<String>();
			List<String> lastNames = new ArrayList<String>();
			List<String> userIDs = new ArrayList<String>();
			List<String> emailAddresses = new ArrayList<String>();
			
			for (int i = 0; i < result.size(); i++){
				Map<String, String> userInfo = new HashMap<String, String>();
				userNames.add(result.get(i).getUserName());
				firstNames.add(result.get(i).getFirstName());
				lastNames.add(result.get(i).getLastName());
				userIDs.add(String.valueOf(result.get(i).getU_ID()));
				emailAddresses.add(result.get(i).getEmailAddress());
			}
			
			
			
			System.out.println("Result");
			System.out.println(userInfoArr);
			
			if (result != null){
				//m.addAttribute("employees", result);
				m.addAttribute("username", userNames);
				m.addAttribute("firstName", firstNames);
				m.addAttribute("lastName", lastNames);
				m.addAttribute("userID", userIDs);
				m.addAttribute("email", emailAddresses);
				
				return "tempEmps";
			}
			else{
				return "manager";
			}
		}

}
