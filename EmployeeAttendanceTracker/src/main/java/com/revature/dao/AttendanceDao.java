package com.revature.dao;

import java.util.List;

import com.revature.beans.AttendanceHistory;

public interface AttendanceDao {
	public List<AttendanceHistory> getAllAttendHistory();
	public List<AttendanceHistory> getAttendHistoryByUser(int id);
	public void clockInAndOut(AttendanceHistory hist);
}
