package com.tj.ex01_store;
// 인터페이스 : 추상메소드와 public 상수만 가능 - 기능만 적어놓는 것(작업 명세서 처럼)
// 때문에 굳이 abstract 안써줘도 됨
public interface HeadQuarterStore {

	public double PI = 3.141592; //<- public static final 상수만 가능. 때문에 'static final' 생략 가능
		// 추상 메소드 : 메소드 선언부만 있는 메소드(구현부는 없음)
	public void kimchi();
	
	public void budai();
	
	public void bibib();
	
	public void sundai();
	
	public void gongibab();

	}

