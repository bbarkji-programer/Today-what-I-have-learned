package com.tj.loop;
/* ��°�� : 15 16 17 18 19
 * 			20 21 22 23 24
 * 			...........49
 *          50  
 */			
public class For_ex04 {

	public static void main(String[] args) {
		
		for(int i=15 ; i<=50 ; i++) {
			System.out.print(i+"\t");
			if(i%5==4) {              // ���� �߰� -> 5�� �������� �� �������� 4�� ��� ����(�ٹٲ�) �Ѵ�.
				System.out.println(); // ���� �߰�
			}
		}
		
	}
}
