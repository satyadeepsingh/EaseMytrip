package org.emt.com.asdits.db.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMT_USERS")
public class User implements Serializable{
	
	private static final long serialVersionUID = -6286189815268255594L;
	
	@Id
	@SequenceGenerator(name="UsersUserIdSeq", sequenceName="SEQ_USERS_USERID", allocationSize=50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UsersUserIdSeq0")
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="NAME")
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Login login;
	
	@Column(name="ADDRESS_LINE1")
	private String addressline1;
	
	@Column(name="ADDRESS_LINE2")
	private String addressline2;
	
	@Column(name="PINCODE")
	private String pincode;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;

	@Column(name="EMAIL")
	private String email;
	
	public User() {
		
	}
	
	public User(String name, Login login, String addressline1, String addressline2, String pincode,
			String city, String state, String country, String email) {
		super();
		this.name = name;
		this.login = login;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public String getAddressline1() {
		return addressline1;
	}


	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}


	public String getAddressline2() {
		return addressline2;
	}


	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
