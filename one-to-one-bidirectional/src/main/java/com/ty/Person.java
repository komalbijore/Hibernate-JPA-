package com.ty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String name;
	private String email;
	private long phone;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aadhaar_card")
	private AadhaarCard aadhaarCard;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid=pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public AadhaarCard getAadhaarCard() {
		return aadhaarCard;
	}
	public void setAadhaarCard(AadhaarCard aadhaarCard) {
		this.aadhaarCard = aadhaarCard;
	}

}
