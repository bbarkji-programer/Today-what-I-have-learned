package com.tj.ex01_string;

import java.util.Scanner;

// substring() lastIndexOf()
public class Ex06_tels {

	public static void main(String[] args) {
		
		String[] tels = {"010-1111-1111", "010-1111-2222", "010-2222-2222", "010-3333-2222"};
		Scanner scanner = new Scanner(System.in);
		String searchTel;
		int idx;
		boolean searchOk = false; // �˻��� ����� ������ true (�⺻�����δ� false�� �ʱ�ȭ)
		
		System.out.println("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ���? ");
		searchTel = scanner.next(); // �����̽��� ���� �ȵȴ�
		for(idx=0 ; idx<tels.length ; idx++) {	
			String temp = tels[idx].substring(tels[idx].lastIndexOf('-')+1 );// ��ȭ��ȣ ���ڸ� ������ : (������ '-'�� �ε���+1(����))���� �����
			if(temp.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� "+tels[idx]);
				searchOk = true ; // ã�Ҵ�.
			}
		}
		if(!searchOk) { // searchOk�� false�� �ƴϸ� = true��?
			System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
		}
		
		scanner.close();
	}
}
