package com.revature.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="REQUEST_HISTORY")
public class RequestHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public RequestHistory(){}
	
	
	public RequestHistory(int totalDays, int daysUsed, int daysLeft){
		this.totalDays = totalDays;
		this.daysUsed = daysUsed;
		this.daysLeft = daysLeft;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reqHistSeq")
	@SequenceGenerator(allocationSize=1,name="reqHistSeq",sequenceName="REQHIST_SEQ")
	@Column(name="RH_ID")
	private int reqHistid;
	
	
	@ManyToOne
	@JoinColumn(name="RH_USER_ID")
	private UserBean user;
	
	@OneToOne
	@JoinColumn(name="RH_TYPE_ID")
	private RequestType requestType;
	
	
	@Column(name="RH_TOTAL_DAYS")
	private int totalDays;
	
	@Column(name="RH_DAY_USED")
	private int daysUsed;
	
	@Column(name="RH_DAY_LEFT")
	private int daysLeft;


	public int getReqHistid() {
		return reqHistid;
	}


	public void setReqHistid(int reqHistid) {
		this.reqHistid = reqHistid;
	}


	public UserBean getUser() {
		return user;
	}


	public void setUser(UserBean user) {
		this.user = user;
	}


	public RequestType getRequestType() {
		return requestType;
	}


	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}


	public int getTotalDays() {
		return totalDays;
	}


	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}


	public int getDaysUsed() {
		return daysUsed;
	}


	public void setDaysUsed(int daysUsed) {
		this.daysUsed = daysUsed;
	}


	public int getDaysLeft() {
		return daysLeft;
	}


	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "RequestHistory [reqHistid=" + reqHistid + ", user=" + user + ", requestType=" + requestType
				+ ", totalDays=" + totalDays + ", daysUsed=" + daysUsed + ", daysLeft=" + daysLeft + "]";
	}	

}

