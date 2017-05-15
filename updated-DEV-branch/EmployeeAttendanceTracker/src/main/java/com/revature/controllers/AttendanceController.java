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
		
		Map<String, String>[] userInfoArr = new HashMap[result.size()];
	
		List<String> attdUserID = new ArrayList<String>();
		List<String> attdHistID = new ArrayList<String>();
		List<String> clockIn = new ArrayList<String>();
		List<String> clockOut = new ArrayList<String>();
		List<String> date = new ArrayList<String>();
		List<String> diff = new ArrayList<String>();
		List<String> tardy = new ArrayList<String>();
		
		for (int i = 0; i < result.size(); i++){
			Map<String, String> userInfo = new HashMap<String, String>();
			
			attdUserID.add(String.valueOf(result.get(0).getUser().getU_ID()));
			attdHistID.add(String.valueOf(result.get(0).getAh()));
			clockIn.add(String.valueOf(result.get(0).getClockIn()));
			clockOut.add(String.valueOf(result.get(0).getClockOut()));
			diff.add(String.valueOf(result.get(0).getDiff()));
			tardy.add(String.valueOf(result.get(0).getLate()));
		}
		
		if (result != null){
			m.addAttribute("attendHistID", attdHistID);
			m.addAttribute("attendClockIn", clockIn);
			m.addAttribute("attendClockout", clockOut);
			m.addAttribute("attendDate", date);
			m.addAttribute("attendDiff", diff);
			m.addAttribute("attendTardy", tardy);
			m.addAttribute("attendUserID", attdUserID);
			
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
	
		List<String> attdUserID = new ArrayList<String>();
		List<String> attdHistID = new ArrayList<String>();
		List<String> clockIn = new ArrayList<String>();
		List<String> clockOut = new ArrayList<String>();
		List<String> date = new ArrayList<String>();
		List<String> diff = new ArrayList<String>();
		List<String> tardy = new ArrayList<String>();
		
		for (int i = 0; i < result.size(); i++){
			Map<String, String> userInfo = new HashMap<String, String>();
			
			attdUserID.add(String.valueOf(result.get(0).getUser().getU_ID()));
			attdHistID.add(String.valueOf(result.get(0).getAh()));
			clockIn.add(String.valueOf(result.get(0).getClockIn()));
			clockOut.add(String.valueOf(result.get(0).getClockOut()));
			date.add(String.valueOf(result.get(0).getDate()));
			diff.add(String.valueOf(result.get(0).getDiff()));
			tardy.add(String.valueOf(result.get(0).getLate()));
		}
		
		if (result != null){
			m.addAttribute("attendHistID", attdHistID);
			m.addAttribute("attendClockIn", clockIn);
			m.addAttribute("attendClockout", clockOut);
			m.addAttribute("attendDate", date);
			m.addAttribute("attendDiff", diff);
			m.addAttribute("attendTardy", tardy);
			m.addAttribute("attendUserID", attdUserID);
			
			return "tempAttendanceHist";
		}
		else{
			return "emp";
		}
	}
}
