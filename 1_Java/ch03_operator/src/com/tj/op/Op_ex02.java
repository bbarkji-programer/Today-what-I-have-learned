package com.tj.op;

public class Op_ex02 {
	public static void main(String[] args) {
		
		System.out.println("* * *����(����) ������* * *");
		
		int n1 = 10;
		
		int n2 = n1++; // �� �������� n1 �� 10 --> n1 ���� ������ (���� ��� ���� ����) ++ �� ����ȴ�. 
		System.out.printf("n1 = %d\t n2 = %d\n",n1,n2);
		
		int n3 = ++n1;
		System.out.printf("n1 = %d\t n3 = %d\n",n1,n3);
		System.out.printf("n3 = %d, %d, %d\n", n3++, ++n3, n3);
		System.out.printf("n3 = %d\n", n3--); // ���� ������ �־�� �� ���� ���� ���� -- �� ����ȴ�.
	}
}
