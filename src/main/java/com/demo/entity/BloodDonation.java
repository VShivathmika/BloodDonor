package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
public class BloodDonation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String emailid;
	
	@Column(nullable = false,unique=true)
	private long mobilenumber;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String bloodgroup;
	
	@Column(nullable = false)
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
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

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BloodDonation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloodDonation(int id, String name, String emailid, long mobilenumber, String gender, String address,
			String bloodgroup, int age) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.address = address;
		this.bloodgroup = bloodgroup;
		this.age = age;
	}

	@Override
	public String toString() {
		return "BloodDonation [id=" + id + ", name=" + name + ", emailid=" + emailid + ", mobilenumber=" + mobilenumber
				+ ", gender=" + gender + ", address=" + address + ", bloodgroup=" + bloodgroup + ", age=" + age + "]";
	}
	
	
	
	
	
}
