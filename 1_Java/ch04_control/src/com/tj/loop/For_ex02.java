package com.tj.loop;
// 결과 : 1~20까지 누적합을 출력
// 결과 : 1+2+3+4+...+18+19+20=210
public class For_ex02 {
	public static void main(String[] args) {
		int tot = 0; // 누적할 변수 ('누적'이니까 필요)
		for(int i=1 ; i<=20 ; i++) {
			if(i==20) {
				System.out.print(i);
			}else {
				System.out.print(i+"+");
			}
			tot = tot+i;
			}
		System.out.println("="+tot);
	}
}
