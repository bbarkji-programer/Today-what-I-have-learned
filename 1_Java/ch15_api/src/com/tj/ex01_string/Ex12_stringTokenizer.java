package com.tj.ex01_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenizer {

	public static void main(String[] args) {
		
		String str1 = "������ ���ػ� ������ ������ ������";
		String str2 = "2019/12/10";
		StringTokenizer tokenizer1 = new StringTokenizer(str1); // ����(white space)�� token ����
		StringTokenizer tokenizer2 = new StringTokenizer(str2,"/");
		System.out.println("t1�� ��ū����: "+tokenizer1.countTokens());
		System.out.println("t2�� ��ū����: "+tokenizer2.countTokens());
		while(tokenizer1.hasMoreTokens()) { // ����Ʈ�� ����Ű�� ���� ��ū�� ���� �ִ�? // �� ���� ����ų ���� ���� ���� false�� �Ǽ� �������.
			System.out.println(tokenizer1.nextToken()); // ���(�� ��ū�� �������� ���� ��ū ������)
		}
		while(tokenizer2.hasMoreTokens()) { 
			System.out.println(tokenizer2.nextToken());
		}

	}
}
