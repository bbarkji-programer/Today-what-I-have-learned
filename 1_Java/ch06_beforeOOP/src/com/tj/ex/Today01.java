package com.tj.ex;

import java.util.Scanner;

// ����ڷκ��� ���ϴ� �ܼ� �������� ����ϴ� ���α׷��� ����
// ��, �ܼ��� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�.
// ����ڰ� 2~9 ������ ���� �ƴ� ���� �Է��� �� 2~9 ������ ���� �Է��� ������ ��� �Է� �޴´�.
public class Today01 {
	public static void main(String[] args) {
		// ����ڷκ��� 2~9���� ���ϴ� �������� �޴´�.
		
		Scanner scanner = new Scanner(System.in);
		int num;
		
		do {
			System.out.println("������ �� ���� ����ұ�? ");	
			num = scanner.nextInt();
			if(num<=9 && num>=2) {
				break;
			}else {
				System.out.println("����� �ٽ� �Է����ּ���.");
			}
		}while(true);
		
		guguPrint(num);
		
	}
	
	private static void guguPrint(int num) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", num, i, num * i);
		}
	}
}
