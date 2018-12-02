package org.emt.com.asdits.db.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="EMT_LOGIN", indexes= {@Index(name="LOGIN_INDEX_USERNAME", columnList="LOGIN_USER_ID")})
public class Login implements Serializable{
	
	private static final long serialVersionUID = 3529212687615972496L;
	
	@Id
	@Column(name="LOGIN_USER_ID")
	@SequenceGenerator(name = "LoginUserIdSeq", sequenceName="SEQ_LOGIN_USERID", allocationSize=50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LoginUserIdSeq")
	private Long userId;
	
	@Column(name="USERNAME",nullable=false,unique=true)
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
		
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

}
