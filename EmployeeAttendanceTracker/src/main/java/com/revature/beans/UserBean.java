package com.revature.beans;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.validation.constraints.*;

@Component(value="User")

public class UserBean {
		/*@DateTimeFormat(pattern="yyyy-MM-dd")
		@NotNull(message="please enter your date of birth")
		@Past(message="that's impossible")
		private Date dateOfBirth;*/ 
		//@NotNull(message="please enter your first name")
		private String firstName;
		//@NotNull(message="please enter your last name")
		private String lastName;
		
		@Size(min=6, max=30)
		@NotNull(message="please enter your userName")
		private String userName;
		
		@NotNull
		@Size(min=6, max=30)
		private String password;
		
		//@NotNull(message="Please enter a valid email address")
		//@Size(min=7)
		private String emailAddress;
		//@NotNull
		private int U_ID;
		//@NotNull
		private int UR_ID;
		
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
		public void setU_ID(int u_ID) {
			U_ID = u_ID;
		}
		public int getUR_ID() {
			return UR_ID;
		}
		public void setUR_ID(int uR_ID) {
			UR_ID = uR_ID;
		}
		
}
