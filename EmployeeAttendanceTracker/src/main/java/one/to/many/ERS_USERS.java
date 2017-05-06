package one.to.many;

import javax.persistence.*;

@Entity
@Table(name="ERS_USERS")
public class ERS_USERS {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uIDSeq")
	@SequenceGenerator(allocationSize = 1, name = "uIDSeq", sequenceName = "UID_SEQ")
	@Column(name = "U_ID")
	private int userID;
	
	@Column(name = "U_USERNAME")
	private String userName;
	
	@Column(name = "U_PASSWORD")
	private String password;
	
	@Column(name = "U_FIRSTNAME")
	private String firstName;
	
	@Column(name = "U_LASTNAME")
	private String lastName;
	
	@Column(name = "U_EMAILADDRESS")
	private String emailAddress;
	
	@Column(name = "UR_ID")
	private int userRoleID;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	
	@Override
	public String toString() {
		return "UserRole [userName=" + userName + ", password=" + password + ", userID=" + userID + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", userRoleID=" + userRoleID
				+ "]";
	}
}
