package com.revature.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		List<EmpRequests> result = requestDao.retrieveRequestByEmpID(id);
		
		Map<String, String>[] userInfoArr = new HashMap[result.size()];
		
		List<String> reqID = new ArrayList<String>();
		List<String> description = new ArrayList<String>();
		List<String> end = new ArrayList<String>();
		List<String> ReqName = new ArrayList<String>();
		List<String> start = new ArrayList<String>();
		List<String> resolver = new ArrayList<String>();
		List<String> reqType = new ArrayList<String>();
		List<String> userID = new ArrayList<String>();
		
		for (int i = 0; i < result.size(); i++){
			Map<String, String> userInfo = new HashMap<String, String>();
			reqID.add(String.valueOf(result.get(i).getReq_id()));
			description.add(result.get(i).getDesc());
			end.add(String.valueOf(result.get(i).getReqEndDate()));
			ReqName.add(result.get(i).getReqName());
			start.add(String.valueOf(result.get(i).getReqStartDate()));
			resolver.add(String.valueOf(result.get(i).getResolved()));
			reqType.add(String.valueOf(result.get(i).getRequestType()));
			userID.add(String.valueOf(result.get(i).getuID()));
		}
		
		if (result != null){
			m.addAttribute("requests", result);
			m.addAttribute("Request_ID", reqID);
			m.addAttribute("Description", description);
			m.addAttribute("End_date", end);
			m.addAttribute("Request_Name", ReqName);
			m.addAttribute("Start_Date", start);
			m.addAttribute("Resolved", resolver);
			m.addAttribute("Request_Type", reqType);
			m.addAttribute("User", userID);
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
