package com.tj.ex01_string;

public class Ex01_string {

	public static void main(String[] args) {
		
		String str1 = "java";
		String str2 = "qwer"; // �� �޸𸮿� ������ �׳� �� �ּ� ������.
		String str3 = new String("asdf"); // new �ϸ� �ݵ�� ���� ����.
		String str4 = new String("asdf");
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҴ�.");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҴ�.");
		}
		if(str1==str3) {
			System.out.println("str1�� str3�� ���� �ּҴ�.");
		}else {
			System.out.println("str1�� str3�� �ٸ� �ּҴ�.");
		} // �׷��� ��ü ���Ҷ��� == �ƴϰ� equals �����. �����Ͱ� �������� �ñ��� �Ŵϱ�.. (�ּҰ� ������ �ñ��Ѱ� X)
		if(str3==str4) {
			System.out.println("str3�� str4�� ���� �ּҴ�.");
		}else {
			System.out.println("str3�� str4�� �ٸ� �ּҴ�.");
		}
		System.out.println("str1�� str2�� ���� ��Ʈ���̳�? "+(str1.equals(str2))); 
		System.out.println("str1�� str3�� ���� ��Ʈ���̳�? "+(str1.equals(str3))); // �ּҴ� �ٸ�����, ��Ʈ������ �����ϱ� true.
		System.out.println("str3�� str4�� ���� ��Ʈ���̳�? "+(str3.equals(str4))); // �ּҴ� �ٸ�����, ��Ʈ������ �����ϱ� true.
		System.out.println("str1�� hashcode : "+str1.hashCode());
		System.out.println("str2�� hashcode : "+str2.hashCode());
		System.out.println("str3�� hashcode : "+str3.hashCode());
		System.out.println("str4�� hashcode : "+str4.hashCode());
	}
}
