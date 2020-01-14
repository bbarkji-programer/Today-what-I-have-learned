package com.tj.ex01_student;

public class Student_main {
	public static void main(String[] args) {	
		//���� ����
		Student s1 = new Student("��  ��", 90, 90, 90);
		Student s2 = new Student("�̹α�", 81, 90, 90);
		Student s3 = new Student("�̵���", 91, 90, 90);
		Student s4 = new Student("������", 80, 90, 90);
		Student s5 = new Student("������", 70, 90, 90);
		Student[] student = new Student[5];
		student[0] = s1;
		student[1] = s2;
		student[2] = s3;
        student[3] = s4;
		student[4] = s5;
		String[] title = {"�̸�", "����", "����", "����", "����", "���"};
		int[] tot = new int[5];
		double[] avg = new double[5]; // ��� ���� 0.0 �ʱ�ȭ		
		//����
		line(); // �β��� ���� ���������
		System.out.println("\t\t\t\t����ǥ");		
		line('-',46); // ���� ���� -----------		
		for(String t : title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		line('-',46); // ���� ���� -----------		
		for(Student s : student) {
			//s.print();
			System.out.print(s.infoString()); // �� ��ü �� ��� �� ������
			tot[0] += s.getKor(); // tot[0] = tot[0] + s.getKor() ���� ����
			tot[1] += s.getEng(); // ���� ����
			tot[2] += s.getMat(); // ���� ����
			tot[3] += s.getTot(); // �հ� ����
			tot[4] += s.getAvg(); // ��� ����
		}
		// �迭 ���� ������ ���� for �Ϲ� ������ ���
		for(int idx=0 ; idx<avg.length ; idx++) { // ��� ���
			avg[idx] = tot[idx] / student.length;
		}
		line('-',46); // ���� ���� -----------
		System.out.print("\t����");
		for(int t : tot) { // Ȯ�� ����
			//System.out.print("\t"+t);
			System.out.printf("\t%4d", t);
		}
		System.out.print("\n\t���");
		for(double a : avg) {
			System.out.print("\t"+a);
		}
		System.out.println();
		line(); // �β��� ���� ���������
	}//main
	//�޼ҵ�~
	private static void line() {
		for(int i=0 ; i<63 ; i++) {
			System.out.print('��');
		}
		System.out.println(); // ����
	}
	private static void line(char ch, int cnt ) {
		System.out.print("\t");
		for(int i=0 ; i<cnt ; i++) { // �� �ٿ� cnt�� ch�� ���
			System.out.print(ch);
		}
		System.out.println(); // ����
	}	
}
