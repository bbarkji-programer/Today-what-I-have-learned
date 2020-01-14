package com.tj.ex01_trycatch;

public class Ex03 {
	public static void main(String[] args) {
		int[] iArr = {0,1,2};
		for(int idx=0 ; idx<=iArr.length ; idx++) {
			try {
				System.out.println("============================");
				System.out.println("iArr["+idx+"] = "+iArr[idx]);
				System.out.println("============================");
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("���ܸ޽���: "+e.getMessage());
				//e.printStackTrace();
			}finally {
				System.out.println("try�� ���� �Ŀ��� �̺κ��� �����ϰ�, catch�� ���� �Ŀ��� �̺κ��� �� ����");
			}
		}//for
	}//main
}//class
