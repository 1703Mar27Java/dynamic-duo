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

import com.revature.beans.AttendanceHistory;
import com.revature.beans.EmpRequests;
import com.revature.dao.AttendanceDaoImpl;
import com.revature.dao.RequestDaoImpl;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	AttendanceDaoImpl histDao;
	
	@RequestMapping(value="/history",method=RequestMethod.POST)
	public String getAttendHistory(Model m, @RequestParam(value="U_ID", required=false) int id){
		List<AttendanceHistory> result = histDao.getAttendHistoryByUser(id);
		//List<AttendanceHistory> result = AttendanceDaoImpl
		
		Map<String, String>[] userInfoArr = new HashMap[result.size()];
		
		/*List<String> reqID = new ArrayList<String>();
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
		}*/
		
		if (result != null){
			/*m.addAttribute("requests", result);
			m.addAttribute("Request_ID", reqID);
			m.addAttribute("Description", description);
			m.addAttribute("End_date", end);
			m.addAttribute("Request_Name", ReqName);
			m.addAttribute("Start_Date", start);
			m.addAttribute("Resolved", resolver);
			m.addAttribute("Request_Type", reqType);
			m.addAttribute("User", userID);*/
			m.addAttribute("AttendHist", result);
			return "tempAttendanceHist";
		}
		else{
			return "emp";
		}
	}
	
	@RequestMapping(value="/history/all",method=RequestMethod.POST)
	public String getAttendHistory(Model m){
		
		List<AttendanceHistory> result = histDao.getAllAttendHistory();
		
		Map<String, String>[] userInfoArr = new HashMap[result.size()];
		
		/*List<String> reqID = new ArrayList<String>();
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
		}*/
		
		if (result != null){
			/*m.addAttribute("requests", result);
			m.addAttribute("Request_ID", reqID);
			m.addAttribute("Description", description);
			m.addAttribute("End_date", end);
			m.addAttribute("Request_Name", ReqName);
			m.addAttribute("Start_Date", start);
			m.addAttribute("Resolved", resolver);
			m.addAttribute("Request_Type", reqType);
			m.addAttribute("User", userID);*/
			m.addAttribute("AttendHist", result.get(0).getDiff());
			return "tempAttendanceHist";
		}
		else{
			return "emp";
		}
	}
}
