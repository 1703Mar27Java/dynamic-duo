package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="USERS")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public User(){}
	
	public User (String fn, String ln, String un, String pw, String em){
		this.fn = fn;
		this.ln = ln;
		this.un = un;
		this.pw = pw;
		this.em = em;
	
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userSeq")
	@SequenceGenerator(allocationSize=1,name="userSeq",sequenceName="USER_SEQ")
	@Column(name="U_ID")
	private int id;
	
	@Column(name="U_FIRST_NAME")
	private String fn;
	
	@Column(name="U_LAST_NAME")
	private String ln;
	
	@Column(name="U_USERNAME", nullable=false)
	private String un;
	
	@Column(name="U_PASSWORD", nullable=false)
	private String pw;
	
	@Column(name="U_EMAIL")
	private String em;
	
	@OneToOne(mappedBy="user")
	private UserRole userrole;
	
	@OneToMany(mappedBy="user")
	private List<AttendanceHistory> attendanceHistory;
	
	@OneToMany(mappedBy="user")
	private List<RequestHistory> requestHistory;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEm() {
		return em;
	}

	public void setEm(String em) {
		this.em = em;
	}

	public UserRole getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}

	public List<AttendanceHistory> getAttendanceHistory() {
		return attendanceHistory;
	}

	public void setAttendanceHistory(List<AttendanceHistory> attendanceHistory) {
		this.attendanceHistory = attendanceHistory;
	}

	public List<RequestHistory> getRequestHistory() {
		return requestHistory;
	}

	public void setRequestHistory(List<RequestHistory> requestHistory) {
		this.requestHistory = requestHistory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	

	
	
}
