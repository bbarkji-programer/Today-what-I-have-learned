package com.tj.ex01_string;

public class Ex02_stringApiMethod {
	
	public static void main(String[] args) {
	
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "   java   ";
		String str4 = "abcXabcXabcXabc";
		
		System.out.println("1."+str1.concat(str2)); // abcXabcabcXabc
		System.out.println("2."+str1.substring(3)); // Xabc
		System.out.println("3."+str1.substring(3, 5)); //Xa ; substring(i, j) = substring(i���� j�� �ձ���)
		System.out.println("4."+str1.length()); //7
		System.out.println("5."+str1.toUpperCase()); // ABCXABC
		System.out.println("6."+str1.toLowerCase()); // abcxabc
		System.out.println("7."+str1.charAt(3)); // i��° ���ڸ� �����Ͷ� -> X
		System.out.println("8."+str1.indexOf('b')); // ù ��° b�� ������ '�ε���(�ڸ���)'�� ��� -> 1
		System.out.println("9."+str1.lastIndexOf('b')); // ������ b�� ������ �ε��� -> 5
		System.out.println("10."+str4.indexOf('b', 3)); // 3��° �ε������� ������ b�� ���° �ε�����? -> 5
		System.out.println("11."+str4.indexOf("cX")); // "cX"�� ó�� ������ ù��° �ε����� ��� -> 2
		System.out.println("12."+str4.indexOf('q')); // ���� ������ �ε����� ã���� -> -1 ���
		System.out.println("13."+str1.equals(str2)); // str1�� str2�� ���� ���ڸ� true. abc!=ABC �ٸ��� ��
		System.out.println("14."+str1.equalsIgnoreCase(str2)); // ��ҹ��� ���̴� �׳� ���ٰ� ���� ��. ���ڸ� ������ true. abc=ABC ���� ��
		System.out.println("15."+str3.trim()); // �յ� �����̽� �����ؼ� ���
		System.out.println("16."+str4.replace('a','9')); // a�� �� 9�� �ٲٰڴ�. -> 9bcX9bcX9bcX9bc
		System.out.println("17."+str4.replace("abcX", "O")); // -> OOOOabc
		System.out.println("str1 : "+str1);
		System.out.println("str1 : "+str2);
		System.out.println("str1 : "+str3);
		System.out.println("str1 : "+str4); // �޼ҵ带 �̿��ؼ� �ٲ۴ٰ� �ؼ� ��ü ���� �ٲ�� ���� �ƴ�
}

}
