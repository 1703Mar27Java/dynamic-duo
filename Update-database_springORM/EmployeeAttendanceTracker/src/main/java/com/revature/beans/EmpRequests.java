package com.revature.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="EMP_REQUESTS")
public class EmpRequests {

	public EmpRequests(){}
	
	
	public EmpRequests(String reqName, Timestamp reqStartDate, Timestamp reqEndDate, String desc){
		this.reqName = reqName;
		this.reqStartDate = reqStartDate;
		this.reqEndDate = reqEndDate;
		this.desc = desc;
		
}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reqIdSeq")
	@SequenceGenerator(allocationSize=1,name="reqIdSeq",sequenceName="REQID_SEQ")
	@Column(name="E_REQ_ID")
	private int req_id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="E_REQ_ID")
	private User user;
	
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public RequestType getRequestType() {
		return requestType;
	}


	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
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


	public int getResolved() {
		return resolved;
	}


	public void setResolved(int resolved) {
		this.resolved = resolved;
	}


	@Override
	public String toString() {
		return "EmpRequests [req_id=" + req_id + ", user=" + user + ", requestType=" + requestType + ", reqName="
				+ reqName + ", reqStartDate=" + reqStartDate + ", reqEndDate=" + reqEndDate + ", desc=" + desc
				+ ", resolved=" + resolved + "]";
	}

	
}
