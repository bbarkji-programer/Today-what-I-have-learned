package com.tj.ex01_string;

import java.util.Scanner;

// substring() lastIndexOf()
public class Ex05_tels {

	public static void main(String[] args) {
		
		String[] tels = {"010-1111-1111", "010-1111-2222"};
		Scanner scanner = new Scanner(System.in);
		String searchTel;
		int idx;
		System.out.println("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ���? ");
		searchTel = scanner.next(); // �����̽��� ���� �ȵȴ�
		for(idx=0 ; idx<tels.length ; idx++) {	
			String temp = tels[idx].substring(tels[idx].lastIndexOf('-')+1 );// ��ȭ��ȣ ���ڸ� ������ : (������ '-'�� �ε���+1(����))���� �����
			if(temp.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� "+tels[idx]);
				break;
			}
		}
		if(idx==tels.length) { // �� ã�� ������ �� ���
			System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
		}
		
		scanner.close();
	}
}
