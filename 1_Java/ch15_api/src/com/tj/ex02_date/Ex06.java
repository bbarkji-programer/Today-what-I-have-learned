package com.tj.ex02_date;

import java.util.Calendar;

import com.tj.ex01_string.Friend;
// ���� ������ ��� �Ѹ���. ������ ���ٰ� �ϱ�.
public class Ex06 {
	
	public static void main(String[] args) {
		
	//�̷� �����Ͱ� �ִٰ� ġ��,
	Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-16"),
						new Friend("ȫ�浿", "010-9999-9999", "12-11"),
						new Friend("ȫ�浿", "010-9999-9999", "01-08")};
	
	// �ý��ۿ��� ���ϰ�������
	Calendar today = Calendar.getInstance(); // ���ݽ��� ������
	int month = today.get(Calendar.MONTH)+1;
	int day = today.get(Calendar.DAY_OF_MONTH);
	
	String monthStr = (month<10) ? "0"+month : ""+month;
	String dayStr = (day<10) ? "0"+day : ""+day;
	String todayStr = monthStr + "-" +dayStr;
	
	System.out.println("������ "+todayStr);
	boolean searchOk = false;
	
	// ������ ���� ��찡 �ִ��� Ȯ��
	for(Friend friend : friends) { // friend : �ӽú���
		if(friend.getBirth().equals(todayStr)) {
			System.out.println("���� ������ ģ����\n"+friend.infoString());
			searchOk = true;
		}
	}
	if(!searchOk) {
		System.out.println("���� ������ ģ���� �����ϴ�.");
	}
	
	}

}