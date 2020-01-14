package com.tj.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon1 {

	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING";
	public static final String DESIGN = "DESIGN";
	public static final String ACCOUNUNG= "ACCOUNING";
	public static final String HUMANRESOURCES = "HUMANRESOURCES";	
	private String no; // ���
	private String name; // �̸�
	private String part; // �μ� COMPUTER, PLANNING, DESIGN, ACCOUNINT, HUMANRESOURCES
	private Date enterDate; // �Ի����� ����Ʈ��
	
	// �����Լ����� Sawon1 kim = new Sawon1("d102-01","ȫ�浿","PLANNING"); <- ������ ��¥�� �Ի���
	
	//�޼ҵ�..........
	public Sawon1(String no, String name, String part) {
		this.no = no;
		this.name = name;
		this.part = part;
		enterDate = new Date();
	}
	
	// Sawon1 y1 = new Sawon1("d102-02", "ȫ�浿", "DESIGN", 1990,12,11); <- Ư���� �� �Ի���
	public Sawon1(String no, String name, String part, int year, int month, int day) {
		this.no = no;
		this.name = name;
		this.part = part;
//		enterDate = new Date(year-1900, month-1, day);
		enterDate = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
	}
	public String infoString() {
		// [���] d102-02 [�̸�] ȫ [�μ�] DESIGN [�Ի���} 1990�� 12�� 11�� <- simpleDateFormat ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		return "[���]"+no+" [�̸�]"+name+" [�μ�]"+part+" [�Ի���]"+sdf.format(enterDate);
	}
}
