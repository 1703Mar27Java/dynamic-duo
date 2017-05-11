package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="USER_ROLE")
public class UserRoleBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="roleSeq")
	@SequenceGenerator(allocationSize=1,name="roleSeq",sequenceName="ROLE_SEQ")
	@Column(name="UR_ID")
	private int urID;
	
	@Column(name="U_ROLE", nullable=false)
	private String urRole;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private UserBean user;

	
	public UserRoleBean(){
		super();
	}
	
	public int getUrID() {
		return urID;
	}
	
	public UserRoleBean(String urRole){
		this.urRole = urRole;
	}

	public void setUrID(int urID) {
		this.urID = urID;
	}

	public String getUrRole() {
		return urRole;
	}

	public void setUrRole(String urRole) {
		this.urRole = urRole;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserRoles [urID=" + urID + ", urRole=" + urRole + "]";
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
}
