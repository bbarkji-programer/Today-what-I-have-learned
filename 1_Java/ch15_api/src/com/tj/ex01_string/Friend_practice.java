package com.tj.ex01_string;

public class Friend_practice {

	private String name;
	private String tel;
	private String birth;
	
	public Friend_practice(String name, String tel, String birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	public String infoString() {
		return "[�̸�]"+name+" [��ȭ]"+tel+" [����]"+birth;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
		
		
	}

