package com.tj.ex03_set;

public class Student {
	private String name;
	private int grade;

	public Student() {		
	}
	public Student(String name, int grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return name+" : "+grade;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Student) {
			String objStr = obj.toString();
			String thisStr = toString();
			return thisStr.equals(objStr);
	}else {
		return false;
	}
//		if(obj!=null && obj instanceof Student) {
//			boolean nameChk = this.name.equals(((Student)obj).name);
//			boolean gradeChk = this.grade == ((Student)obj).grade;
//			return nameChk && gradeChk;
//		}else {
//		return false;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}

