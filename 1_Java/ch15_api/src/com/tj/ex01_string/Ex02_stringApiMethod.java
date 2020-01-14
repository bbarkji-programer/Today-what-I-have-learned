package com.tj.ex01_string;

public class Ex02_stringApiMethod {
	
	public static void main(String[] args) {
	
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "   java   ";
		String str4 = "abcXabcXabcXabc";
		
		System.out.println("1."+str1.concat(str2)); // abcXabcabcXabc
		System.out.println("2."+str1.substring(3)); // Xabc
		System.out.println("3."+str1.substring(3, 5)); //Xa ; substring(i, j) = substring(i부터 j번 앞까지)
		System.out.println("4."+str1.length()); //7
		System.out.println("5."+str1.toUpperCase()); // ABCXABC
		System.out.println("6."+str1.toLowerCase()); // abcxabc
		System.out.println("7."+str1.charAt(3)); // i번째 문자를 가져와라 -> X
		System.out.println("8."+str1.indexOf('b')); // 첫 번째 b가 나오는 '인덱스(자리수)'를 출력 -> 1
		System.out.println("9."+str1.lastIndexOf('b')); // 마지막 b가 나오는 인덱스 -> 5
		System.out.println("10."+str4.indexOf('b', 3)); // 3번째 인덱스부터 나오는 b는 몇번째 인덱스야? -> 5
		System.out.println("11."+str4.indexOf("cX")); // "cX"가 처음 나오는 첫번째 인덱스를 출력 -> 2
		System.out.println("12."+str4.indexOf('q')); // 없는 글자의 인덱스를 찾으면 -> -1 출력
		System.out.println("13."+str1.equals(str2)); // str1과 str2가 같은 문자면 true. abc!=ABC 다르게 봄
		System.out.println("14."+str1.equalsIgnoreCase(str2)); // 대소문자 차이는 그냥 같다고 보는 것. 글자만 같으면 true. abc=ABC 같게 봄
		System.out.println("15."+str3.trim()); // 앞뒤 스페이스 제외해서 출력
		System.out.println("16."+str4.replace('a','9')); // a를 다 9로 바꾸겠다. -> 9bcX9bcX9bcX9bc
		System.out.println("17."+str4.replace("abcX", "O")); // -> OOOOabc
		System.out.println("str1 : "+str1);
		System.out.println("str1 : "+str2);
		System.out.println("str1 : "+str3);
		System.out.println("str1 : "+str4); // 메소드를 이용해서 바꾼다고 해서 객체 값이 바뀌는 것은 아님
}

}
