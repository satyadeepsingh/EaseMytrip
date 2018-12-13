package org.ems.com.asdits.db.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="EMS_LOGIN", indexes= {@Index(name="LOGIN_INDEX_USERNAME", columnList="USERNAME")})
public class Login implements Serializable{
	
	private static final long serialVersionUID = 3529212687615972496L;
	
	@Id
	@Column(name="USERNAME",nullable=false,unique=true)
	private String username;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Column(name="ROLE", nullable=false)
	@OneToMany(fetch=FetchType.LAZY,mappedBy="login")
	private List<UserRole> role;
		
	public Login() {
		super();
	}

	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getRole() {
		return role;
	}

	public void setRole(List<UserRole> role) {
		this.role = role;
	}
	
	

}
