package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="USER_ROLE")
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public UserRole(){}
	
	public UserRole(String role){
		this.role = role;
	
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="roleSeq")
	@SequenceGenerator(allocationSize=1,name="roleSeq",sequenceName="ROLE_SEQ")
	@Column(name="UR_ID")
	private int ur_id;
	
	@Column(name="U_ROLE", nullable=false)
	private String role;

	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUr_id() {
		return ur_id;
	}

	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserRole [ur_id=" + ur_id + ", role=" + role + ", user=" + user + "]";
	}

	
	
}
