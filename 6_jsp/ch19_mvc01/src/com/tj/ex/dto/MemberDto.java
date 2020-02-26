package com.tj.ex.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date birth;
	private Timestamp rdate;
	private String address;
	
	public MemberDto() {
		super();
	}

	public MemberDto(String id, String pw, String name, String email, Date birth, Timestamp rdate, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.rdate = rdate;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Timestamp getRdate() {
		return rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", birth=" + birth
				+ ", rdate=" + rdate + ", address=" + address + "]";
	}
	

}
