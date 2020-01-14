package com.tj.ex05_lib;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ExDayCount {
	public static void main(String[] args) {
//		Date checkOutDate = new Date(119, 10, 13); // 2019.11.13
		Date checkOutDate = new Date(new GregorianCalendar(2019,10,13).getTimeInMillis()); // 2019.11.13
		Date today = new Date();
		long checkOutMillis = checkOutDate.getTime(); // 1970.1.1~2019.11.13���� �и�����
		long todayMillis = today.getTime(); // 1970.1.1~2019.12.13���� �и�����
		long borrowMillis = todayMillis - checkOutMillis; // ���� �Ⱓ �и�����
		long borrowDays = borrowMillis/(24*60*60*1000); // ���� �Ⱓ �� ��
		if(borrowDays>14) {
			System.out.println((borrowDays-14)*100+"�� ��ü�Ḧ ���ž� �ݳ�ó�� �����մϴ�.");
			Scanner sc = new Scanner(System.in);
			System.out.println("��ü�Ḧ �����̳���? (N:�ݳ��ߴ�, Y:�ݳ�����)");
			String answer = sc.nextLine();
			if(answer.equalsIgnoreCase("n")) {
				System.exit(0); // System.exit(0) <- 0 �̸� �������Ḧ ����.  checkIn method������ return���� ��ü. 
			}//if
		}//if
		System.out.println("�ݳ�ó�� ��� ����");
		
	}
}
