package com.tj.ex01_string;

import java.util.Scanner;

public class Q01 {
	
	public static void main(String[] args) {
	
		System.out.println("��ȭ��ȣ(031-234-5678)�� �Է����ּ���.");
		String tel; // �Է¹��� ��ȭ��ȣ ���� ����(�ʱ�ȭX)


		while(true) {		// while(true)�ϱ� �߰��� break; �� ���������� �ʴ� �̻� ��� �ݺ��Ѵ�.
			Scanner scanner = new Scanner(System.in); // ��ȭ��ȣ�� �Է¹���.
			tel = scanner.next(); // �׷� �� �Է¹��� ������ ���� �ʱ�ȭ
			
			if(tel.equalsIgnoreCase("x")) { // ���࿡ �Է¹��� ���� x �Ǵ� X�̸�,
				System.out.println("�����մϴ�."); // ���α׷� ���� �˷��ְ�
			break; // �ݺ��� ����������
			}
			else if(tel.length()>10 && tel.length()<14 && tel.indexOf('-')!=tel.lastIndexOf('-')) {		// X�� �ƴ� ���𰡸� �Է��ߴµ�, �װ� 10���� �Ѱ�, 14���ں��� ª��, '-'�� 2���� ����� ������(=����� �Է�������)
				System.out.println("�Է��� ��ȭ��ȣ : "+tel); // �� ��ȭ��ȣ ���
				System.out.print("¦�� �� ° ���ڿ� : "); // ¦����° ���ڿ� ���,
					for(int i=1 ; i<tel.length() ; i++ ) {
						if(i%2 != 0) {
							System.out.print(tel.charAt(i));
						}
					}
					System.out.println();
					System.out.print("��ȭ��ȣ�� �Ųٷ� : ");
					for(int i=tel.length()-1 ; i>=0 ; i--) {
						System.out.print(tel.charAt(i));
					}
					System.out.println();
					System.out.println("��ȭ��ȣ ���ڸ��� : "+tel.substring(0,tel.indexOf('-')));
					System.out.println("��ȭ��ȣ ���ڸ��� : "+tel.substring(tel.lastIndexOf('-')+1));	
			}
			else {
				System.out.println("�߸��� ��ȣ�� �Է��߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
		
	}
}
