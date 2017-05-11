package com.revature.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Check;


@Entity
@Table(name="ATTENDANCE_HISTORY")
public class AttendanceHistory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public AttendanceHistory(){}
	
	public AttendanceHistory(Timestamp date, Timestamp clockIn, Timestamp clockOut, int diff, int late){
		
		this.date = date;
		this.clockIn = clockIn;
		this.clockOut = clockOut;
		this.diff = diff;
		this.late = late;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="attendHistSeq")
	@SequenceGenerator(allocationSize=1,name="attendHistSeq",sequenceName="ATTENDHIST_SEQ")
	@Column(name="A_HIST_ID")
	private int ah;
	
	@ManyToOne
	@JoinColumn(name="A_USER_ID")
	private UserBean user;
	
	@Column(name="A_DATE")
	private Timestamp date;
	
	@Column(name="A_CLOCK_IN")
	private Timestamp clockIn;
	
	@Column(name="A_CLOCK_OUT")
	private Timestamp clockOut;
	
	@Column(name="A_DIFF_HRS")
	private int diff;
	
	@Column(name="A_TARDY")
	private int late;

	public int getAh() {
		return ah;
	}

	public void setAh(int ah) {
		this.ah = ah;
	}

	
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Timestamp getClockIn() {
		return clockIn;
	}

	public void setClockIn(Timestamp clockIn) {
		this.clockIn = clockIn;
	}

	public Timestamp getClockOut() {
		return clockOut;
	}

	public void setClockOut(Timestamp clockOut) {
		this.clockOut = clockOut;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AttendanceHistory [ah=" + ah + ", user=" + user + ", date=" + date + ", clockIn=" + clockIn
				+ ", clockOut=" + clockOut + ", diff=" + diff + ", late=" + late + "]";
	}

	
	
}
