package com.tj.ex04_object;

public class Person {

	private long juminNo; // 9001082111111

	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "주민번호: "+juminNo;
	}
	
	@Override
	public boolean equals(Object obj) {
//		 public boolean equals(Object obj) {
//		        return (this == obj);
//       메인에서는 p1.equals(p2) p1 이렇게 사용, 이때  -> this, p2 -> obj
		if(obj!=null && obj instanceof Person) {
			return this.juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
		
	}
	
	
	
}
