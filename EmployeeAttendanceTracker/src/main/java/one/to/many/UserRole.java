//used for hibernate

package one.to.many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="ERS_USER_ROLES")
public class UserRole {
	private String urRole;
	private int urID;
	public String getUrRole() {
		return urRole;
	}
	public void setUrRole(String urRole) {
		this.urRole = urRole;
	}
	public int getUrID() {
		return urID;
	}
	public void setUrID(int urID) {
		this.urID = urID;
	}
}
