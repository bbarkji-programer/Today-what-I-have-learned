package com.tj.loop;
// �� ���� �ֻ����� ������ ��, �μ��� ���� 6�̵Ǵ� ��츦 ���
public class Homework_03 {
	public static void main(String[] args) {
		for(int i=1 ; i<=6 ; i++) {
			for(int j=1 ; j<=6 ; j++) {
				if(i+j == 6) {
					System.out.println("i�ֻ���: "+i+", j�ֻ���: "+j);
				}//if
			}//for-j
		}//for-i
	}//main
}//class
