package com.tj.ex01_string;

public class Ex01_string {

	public static void main(String[] args) {
		
		String str1 = "java";
		String str2 = "qwer"; // 힙 메모리에 있으면 그냥 그 주소 가져옴.
		String str3 = new String("asdf"); // new 하면 반드시 새로 만듬.
		String str4 = new String("asdf");
		if(str1==str2) {
			System.out.println("str1과 str2는 같은 주소다.");
		}else {
			System.out.println("str1과 str2는 다른 주소다.");
		}
		if(str1==str3) {
			System.out.println("str1과 str3은 같은 주소다.");
		}else {
			System.out.println("str1과 str3은 다른 주소다.");
		} // 그래서 객체 비교할때는 == 아니고 equals 써야행. 데이터가 같은지가 궁금한 거니까.. (주소가 같은게 궁금한게 X)
		if(str3==str4) {
			System.out.println("str3과 str4은 같은 주소다.");
		}else {
			System.out.println("str3과 str4은 다른 주소다.");
		}
		System.out.println("str1와 str2가 같은 스트링이냐? "+(str1.equals(str2))); 
		System.out.println("str1와 str3가 같은 스트링이냐? "+(str1.equals(str3))); // 주소는 다르지만, 스트링값은 같으니까 true.
		System.out.println("str3와 str4가 같은 스트링이냐? "+(str3.equals(str4))); // 주소는 다르지만, 스트링값은 같으니까 true.
		System.out.println("str1의 hashcode : "+str1.hashCode());
		System.out.println("str2의 hashcode : "+str2.hashCode());
		System.out.println("str3의 hashcode : "+str3.hashCode());
		System.out.println("str4의 hashcode : "+str4.hashCode());
	}
}
