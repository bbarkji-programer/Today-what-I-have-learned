package com.tj.ex;

import java.util.Scanner;

// �迭�� �̿��Ͽ� �л���(����, ö��, �浿, ����, ����)�� Ű�� �Է¹ް�
// ���� ū �л��� ���� ���� �л��� ������ ����.
public class Array_ex04 {
	public static void main(String[] args) {
		
		
		String[] arrName = {"����","ö��","�浿","����","����"};
		int[] arrHeight = new int[5];
		Scanner scanner = new Scanner(System.in);
		//�迭 �����
		
		for(int idx=0 ; idx < arrName.length ; idx++) {
			System.out.println(arrName[idx]+"�� Ű�� ?");
			arrHeight[idx] = scanner.nextInt();	
		}//Ű �Է� �ޱ�
		
		scanner.close();
		
		int min = 9999; // �ּ�Ű
		int max = 0;    // �ִ�Ű
		int tot = 0;    // Ű ����
		int minIndex=-1, maxIndex=-1;
		
		for(int idx=0 ; idx < arrName.length ; idx++) {
			tot += arrHeight[idx]; // Ű ����
			
			if(arrHeight[idx]<min) {
				min = arrHeight[idx]; // �ּҰ��� min�� �ƴϸ�, min���� �񱳰��� ����
				minIndex = idx;
			}//if - �ּҰ� ó��
			
			if(arrHeight[idx]>max) {
				max = arrHeight[idx];
				maxIndex = idx;
			}//if - �ִ밪 ó��
				}
	    System.out.println("�����Ű(�̸�): "+max+"("+arrName[maxIndex]+")");
		System.out.println("�ִܽ�Ű(�̸�): "+min+"("+arrName[minIndex]+")");
		System.out.printf("���Ű: %.2f\n", (double)tot/arrName.length);
	}
}
