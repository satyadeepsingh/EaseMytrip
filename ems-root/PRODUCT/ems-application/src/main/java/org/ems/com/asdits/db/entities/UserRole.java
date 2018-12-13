package org.ems.com.asdits.db.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="EMS_USER_ROLES")
@Entity
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = -3877053624469416579L;

	@Id
	@Column(name="USER_ROLE")
	private String userRole;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private Login login;
	
	public UserRole() {
		super();
	}

	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	

}
