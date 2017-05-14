package com.revature.beans;

import java.io.Serializable;
//import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="REQUEST_TYPE")
public class RequestType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public RequestType(){}
	
	public RequestType(int duration){
		this.duration = duration;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reqTypeSeq")
	@SequenceGenerator(allocationSize=1,name="reqTypeSeq",sequenceName="REQTYPE_SEQ")
	@Column(name="RT_ID")
	private int r_id;
	
	@OneToOne(mappedBy="requestType",cascade=CascadeType.ALL)
	private RequestHistory requestHistory;
	

	@Column(name="RT_DURATION")
	private int duration;


	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public RequestHistory getRequestHistory() {
		return requestHistory;
	}

	public void setRequestHistory(RequestHistory requestHistory) {
		this.requestHistory = requestHistory;
	}

	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RequestType [r_id=" + r_id + ", requestHistory=" + requestHistory + ", duration=" + duration + "]";
	}




	

}


