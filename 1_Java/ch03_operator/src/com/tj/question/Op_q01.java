package com.tj.question;

import java.util.Scanner;

// ����ڷκ��� ������ �Է� �޾� 3�� ������� �ƴ��� ���
public class Op_q01 {
	public static void main(String[] args) {
	//  ���� ���, String name = ��ٱ����� ������ �޸𸮰� �����ֳ�... <- ���Ҹ���...
	//  String name = "ȫ�浿";
		
		Scanner scanner = new Scanner(System.in); // new �����ڷ� �޸𸮸� ���� ��ٱ����� ������ ��...? �޸𸮿� ������Ű�� ����
		System.out.print("�Է��ϰ��� �ϴ� ���� ���� ?"); // �ѱ� ĥ ���� �����ؾ���, ����Ŭ���� ����Ŷ��
		int i = scanner.nextInt(); // nextInt()�� Ű����κ��� ������ �Է��ϴ� ���� <- ����ڰ� ������ �Է��� ������ ��ٸ���.
		
		System.out.println(i%3==0 ? "3�� ����� �Է��߳�" : "3�� ����� �ƴϱ�");
		scanner.close();
	}
}
