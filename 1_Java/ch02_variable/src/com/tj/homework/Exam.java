package com.tj.homework;
// ��, ��, ��, ����, ���
public class Exam {
	public static void main(String[] args) {
		int kor = 98; // ����� ���ÿ� �ʱ�ȭ(�Ҵ�)
		int eng = 100;
		int mat = 92;
		int tot = kor + eng + mat;
//		double avg = (double)tot / 3; // ����� ����ȯ
		double avg = tot / 3.0; // ������ ����ȯ
		System.out.println("���� : "+kor+"\t���� : "+eng+"\t���� : "+mat);
		System.out.printf("���� : %d\t���: %.2f\n", tot, avg);
}
}
