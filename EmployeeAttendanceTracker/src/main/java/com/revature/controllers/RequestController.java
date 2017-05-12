package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.UserBean;
import com.revature.dao.DaoImpl;
import com.revature.dao.RequestDaoImpl;
import com.revature.beans.EmpRequests;


@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	RequestDaoImpl requestDao;
	
	//retrieve whole req history for single user
	@RequestMapping(value="/history/all",method=RequestMethod.POST)
	public String getReqAllHistory(Model m, @RequestParam(value="U_ID", required=false) int id){
		
		List<EmpRequests> requests = requestDao.retrieveRequestByEmpID(id);
		
		if (requests != null){
			m.addAttribute("requests", requests);
			return "tempRequests";
		}
		else{
			return "manager";
		}
	}
	
	//retrieve most recent request history from user
	@RequestMapping(value="/history/recent",method=RequestMethod.POST)
	public String getSingleRequest(Model m, @RequestParam(value="U_ID", required=false) int id){
		
		EmpRequests request = requestDao.retrieveSingleRequest(id);
		
		if (request != null){
			m.addAttribute("mostRecentRequest", request);
			return "tempSingleRequest";
		}
		else{
			return "manager";
		}
	}
}
