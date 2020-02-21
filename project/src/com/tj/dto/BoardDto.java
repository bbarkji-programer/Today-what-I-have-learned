package com.tj.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int num;
	private String writer;
	private String email;
	private String subject;
	private String content;
	private int hit;
	private String pw;
	private String ip;
	private Timestamp write_date;
	private int row_group;
	private int row_step;
	private int row_level;
	
	public BoardDto() {
	}

	public BoardDto(int num, String writer, String email, String subject, String content, int hit, String pw, String ip,
			Timestamp write_date, int row_group, int row_step, int row_level) {
		super();
		this.num = num;
		this.writer = writer;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.pw = pw;
		this.ip = ip;
		this.write_date = write_date;
		this.row_group = row_group;
		this.row_step = row_step;
		this.row_level = row_level;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

	public int getRow_group() {
		return row_group;
	}

	public void setRow_group(int row_group) {
		this.row_group = row_group;
	}

	public int getRow_step() {
		return row_step;
	}

	public void setRow_step(int row_step) {
		this.row_step = row_step;
	}

	public int getRow_level() {
		return row_level;
	}

	public void setRow_level(int row_level) {
		this.row_level = row_level;
	}

	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", writer=" + writer + ", email=" + email + ", subject=" + subject
				+ ", content=" + content + ", hit=" + hit + ", pw=" + pw + ", ip=" + ip + ", write_date=" + write_date
				+ ", row_group=" + row_group + ", row_step=" + row_step + ", row_level=" + row_level + "]";
	}
	
	
	
}
