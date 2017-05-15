package com.revature.beans;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;


@Entity
@Table(name="EMP_REQUESTS")
@Component(value="Request")
public class EmpRequests {

	public EmpRequests(){}
	
	public EmpRequests(String reqName, Timestamp reqStartDate, Timestamp reqEndDate, String desc){
		this.reqName = reqName;
		this.reqStartDate = reqStartDate;
		this.reqEndDate = reqEndDate;
		this.desc = desc;
		
		java.util.Date utilDate = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(utilDate);
        cal.set(Calendar.MILLISECOND, 0);        //comment.setDate(new java.sql.Timestamp(cal.getTimeInMillis()));
        System.out.println(cal);
		this.reqStartDate = new java.sql.Timestamp(cal.getTimeInMillis());
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reqIdSeq")
	@SequenceGenerator(allocationSize=1,name="reqIdSeq",sequenceName="REQID_SEQ")
	@Column(name="E_REQ_ID")
	private int req_id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="E_REQ_ID")
	private UserBean user;
	
	@OneToOne
	@JoinColumn(name="E_REQ_TYPE")
	private RequestType requestType;
	
	@Column(name="E_REQ_NAME")
	private String reqName;
	
	@Column(name="E_REQ_START")
	private Timestamp reqStartDate;
	
	@Column(name="E_REQ_END")
	private Timestamp reqEndDate;
	
	@Column(name="E_REQ_DESC")
	private String desc;
	
	@Column(name="E_REQ_RESOLVER")
	private int resolved;
	
	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}


	public UserBean getUser() {
		return user;
	}


	public void setUser(UserBean user) {
		this.user = user;
	}


	public String getRequestType() {
		if (requestType.getR_id() == 1){
			return "Vacation";
		}
		else if (requestType.getR_id() == 2){
			return "Unpaid Personal Day";
		}
		else if (requestType.getR_id() == 3){
			return "Medical Leave";
		}
		else if (requestType.getR_id() == 4){
			return "Military Leave";
		}
		else if (requestType.getR_id() == 5){
			return "Two Week Notice";
		}
		else if (requestType.getR_id() == 6){
			return "Other";
		}
		return "NA";
	}


	public void setRequestType(int requestType) {
		this.requestType = new RequestType();
		this.requestType.setR_id(requestType);
	}


	public String getReqName() {
		return reqName;
	}


	public void setReqName(String reqName) {
		this.reqName = reqName;
	}


	public Timestamp getReqStartDate() {
		return reqStartDate;
	}


	public void setReqStartDate(Timestamp reqStartDate) {
		this.reqStartDate = reqStartDate;
	}


	public Timestamp getReqEndDate() {
		return reqEndDate;
	}


	public void setReqEndDate(Timestamp reqEndDate) {
		this.reqEndDate = reqEndDate;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getResolved() {
		if (resolved == 1){
			return "Pending";
		}
		else if (resolved == 2){
			return "Approved";
		}
		else if (resolved == 3){
			return "Denied";
		}
		return "NA";
	}


	public void setResolved(int resolved) {
		this.resolved = resolved;
	}


	@Override
	public String toString() {
		return req_id + "," + user + "," + requestType + ","
				+ reqName + "," + reqStartDate + "," + reqEndDate + "," + desc
				+ "," + resolved;
	}

	
}