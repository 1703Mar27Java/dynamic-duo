package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/request")
public class RequestController {
	//about
	@RequestMapping(value="/history",method=RequestMethod.POST)
	public String getReqHistory(Model m){
		//m.addAttribute("person",new UserBean());
		return "about";
	}
}
