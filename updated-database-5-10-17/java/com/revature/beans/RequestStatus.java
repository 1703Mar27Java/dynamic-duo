package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="REQUEST_STATUS")
public class RequestStatus implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8131046648668614627L;


	public RequestStatus(){}
	
	public RequestStatus(String reqStat){
		this.reqStat = reqStat;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reqStatSeq")
	@SequenceGenerator(allocationSize=1,name="reqStatSeq",sequenceName="REQSTAT_SEQ")
	@Column(name="REQ_STAT_ID")
	private int reqStat_ID;
	
	@Column(name="REQ_STATUS")
	private String reqStat;
	
	@OneToOne(mappedBy="requestStatus")
	private EmpRequests emprequests;


	public String getStatus() {
		return reqStat;
	}

	public void setStatus(String reqStat) {
		this.reqStat = reqStat;
	}


	
	public int getReqStat_ID() {
		return reqStat_ID;
	}

	
	public void setReqStat_ID(int reqStat_ID) {
		this.reqStat_ID = reqStat_ID;
	}

	public EmpRequests getEmprequests() {
		return emprequests;
	}

	public void setEmprequests(EmpRequests emprequests) {
		this.emprequests = emprequests;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RequestStatus [reqStat_ID=" + reqStat_ID + ", reqStat=" + reqStat + ", emprequests=" + emprequests
				+ "]";
	}
	
	
	
	
}

