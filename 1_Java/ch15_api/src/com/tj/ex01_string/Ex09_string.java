package com.tj.ex01_string;
// String�� ���� : �����Ͱ� ���� �� �޸𸮸� ���Һ��Ѵ�. <- �� ������ ���� : StringBuffer, StringBuilder
public class Ex09_string {

	public static void main(String[] args) {
		
		String str1 = "Java"; // 100����
		String str2 = str1; //100����
		str1 = "Python";
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҳ�.");
		
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҳ�.");
		}
		str1 = "python1";
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҳ�.");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҳ�.");
		}
	}
}
