package com.tj.ex06_wrapper;
// java Ŭ������ 100 20 10 ; ��� �Ķ���ͷ� ���� ���ڿ��� ���ڸ� ���Ѵ�.
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("���� �� ����: "+args.length);
		//"10" "20" "3" "5" "6" "7"
		int total = 0;
		for(int idx=0 ; idx<args.length ; idx++) {
			System.out.println(args[idx]);
			total += Integer.parseInt(args[idx]); // Integer.parseInt() ���ڷ� �ٲ� �� �ִ� String��... 
		}
		System.out.println("total = "+total);
	}
}
