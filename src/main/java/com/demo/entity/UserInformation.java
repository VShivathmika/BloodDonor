package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity 
public class UserInformation {
	
	private String username;
	@Id
	private String emailid;
	@Column(unique = true, nullable = false) 
   	private String password;
	@Column(unique = true,nullable = false)
	private long mobilenumber;
	private String gender;
	private String address;
	public UserInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInformation(String username, String emailid, String password, long mobilenumber, String gender,
			String address) {
		super();
		this.username = username;
		this.emailid = emailid;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserInformation [username=" + username + ", emailid=" + emailid + ", password=" + password
				+ ", mobilenumber=" + mobilenumber + ", gender=" + gender + ", address=" + address + "]";
	}
	
	
	
	
}
