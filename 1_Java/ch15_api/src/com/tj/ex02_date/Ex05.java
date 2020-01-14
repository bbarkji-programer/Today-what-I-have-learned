package com.tj.ex02_date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05 {

	public static void main(String[] args) {
		
		//����
		Calendar calNow = Calendar.getInstance();
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dateNow = new Date();
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", calNow);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", gcNow);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", dateNow);
		
		//Ư���� ����(1990.01.08) - *Calendar�� ���� �����ۿ� ��������.
		GregorianCalendar gcBirth = new GregorianCalendar(1990, 0, 8);
		Date dateBirth1 = new Date(90, 0, 8); // �Ǳ� �Ǵµ� �� ����� ����.
		Date dateBirth2 = new Date(gcBirth.getTimeInMillis()); // ����Ʈ�� Ư������ -> �׷����� Ķ���� ��ü �����, �װ��� �и�����... 
		Date dateBirth3 = new Date(new GregorianCalendar(1990, 0, 8).getTimeInMillis()); // ���࿡ �׷����� Ķ���� ��ü �ȸ��� ���, �ٷ� ���� �޼ҵ� ȣ��
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", dateBirth1);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", dateBirth2);
		System.out.printf("%1$TY�� %1$Tm�� %1$Td�� %1$TH�� %1$TM�� %1$TS��\n", dateBirth3);
	}
}
