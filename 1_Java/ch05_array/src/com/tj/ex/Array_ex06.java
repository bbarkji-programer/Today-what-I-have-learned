package com.tj.ex;
// �Ϲ� for vs. Ȯ�� for
public class Array_ex06 {
	public static void main(String[] args) {
		int[] names = {10, 20, 30}; // ��ü�迭
		
		//�Ϲ�for��
		for(int idx = 0; idx < names.length; idx++  ) {
			System.out.println(names[idx]);
			
		}
		
		//Ȯ��for�� - ��¸� �� ��
		for(int temp : names) {
			System.out.println(temp);
		}
		
	}
}
