package com.tj.loop;
// break vs. continue 
public class For_ex05 {
	public static void main(String[] args) {
		for(int i=1 ; i<=10 ; i++) {
			if(i==3) {
				//break; �ƿ� ��������
				continue; // if ���Ǹ� ��� ���ϰ�, �ٽ� ���� �ö�
			}
			System.out.println(i);
		}

	}

}
