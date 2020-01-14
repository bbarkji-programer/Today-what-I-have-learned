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
				System.out.println("예외메시지: "+e.getMessage());
				//e.printStackTrace();
			}finally {
				System.out.println("try절 실행 후에도 이부분을 실행하고, catch절 실행 후에도 이부분은 꼭 실행");
			}
		}//for
	}//main
}//class
