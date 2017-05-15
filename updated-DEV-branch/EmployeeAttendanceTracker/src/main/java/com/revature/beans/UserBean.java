package com.revature.beans;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/*import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;*/

import java.util.Date;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="USERS")
@Component(value="User")
public class UserBean implements Serializable {
	
		public UserBean(){};
	
		public UserBean (String fn, String ln, String un, String pw, String em){
			this.firstName = fn;
			this.lastName = ln;
			this.userName = un;
			this.password = pw;
			this.emailAddress = em;
		}
	
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userSeq")
		@SequenceGenerator(allocationSize=1,name="userSeq",sequenceName="USER_SEQ")
		@Column(name="U_ID")
		@NotNull
		private int U_ID;
		
		/*@DateTimeFormat(pattern="yyyy-MM-dd")
		@NotNull(message="please enter your date of birth")
		@Past(message="that's impossible")
		private Date dateOfBirth;*/ 
		
		@Column(name="U_FIRST_NAME")
		//@NotNull(message="please enter your first name")
		private String firstName;
		
		@Column(name="U_LAST_NAME")
		//@NotNull(message="please enter your last name")
		private String lastName;
		
		@Column(name="U_USERNAME", nullable=false)
		@Size(min=6, max=30)
		@NotNull(message="please enter your userName")
		private String userName;
		
		@Column(name="U_PASSWORD", nullable=false)
		@NotNull
		@Size(min=6, max=30)
		private String password;
		
		private String password2;
		
		@Column(name="U_EMAIL")
		//@NotNull(message="Please enter a valid email address")
		//@Email
		private String emailAddress;
		
		//@NotNull
		/*@Column
		private String userRole;
		
		@Column(name="USERROLE")
		private int uRoleID;*/
		
		
		@OneToOne(mappedBy="user")
		private UserRoleBean userrole;
		
		@OneToMany(mappedBy="user")
		private List<AttendanceHistory> attendanceHistory;
		
		@OneToMany(mappedBy="user")
		private List<RequestHistory> requestHistory;
		
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
		public int getU_ID() {
			return U_ID;
		}
	
		public String getPassword2() {
			return password2;
		}
		public void setPassword2(String password2) {
			this.password2 = password2;
		}
		public String getEmailAddress() {
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		public void setUserRole(UserRoleBean userRole) {
			this.userrole = userRole;
		}
		
		public UserRoleBean getUserRole() {
			return userrole;
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

		public UserRoleBean getUserrole() {
			return userrole;
		}

		public void setUserrole(UserRoleBean userrole) {
			this.userrole = userrole;
		}

		@Override
		public String toString() {
			return "U_ID=" + U_ID + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
					+ userName + ", password=" + password + ", password2=" + password2 + ", emailAddress="
					+ emailAddress + ", userRole=" + userrole + ", uRoleID=" + ", userrole=" + userrole.getUrID()
					+ ", attendanceHistory=" + attendanceHistory + ", requestHistory=" + requestHistory;
		}

		
		
}
