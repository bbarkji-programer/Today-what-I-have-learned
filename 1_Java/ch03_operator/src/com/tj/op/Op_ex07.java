package com.tj.op;

public class Op_ex07 {

	public static void main(String[] args) {
		System.out.println("* * *��Ʈ������* * *");
		
		int i1 = 10; 			// 0 0 0 0 1 0 1 0 (int�� ������ �տ� 000000)
		int i2 = 5;  			// 0 0 0 0 0 1 0 1 <- ��Ʈ ���� ����ϴ� �� ��Ʈ ������ 
		
		int result = i1 & i2;   // 0 0 0 0 0 0 0 0 <- & �ϳ��� ������ ��Ʈ ����. 0�� false, 1�� true 
		System.out.println(result);
		
		result = i1 | i2;		// 0 0 0 0 1 1 1 1 
		System.out.println(result);
		
		result = i1 << 1;       // 0 0 0 1 0 1 0 0 <- i�� �� �ڸ� �������� shift (/2�� ����)
		System.out.println(result);
		
		result = i1 >> 1;       // 0 0 0 0 0 1 0 1 <- i�� �� �ڸ� �������� shift (*2�� ����)
		System.out.println(result);
		
	}

}
