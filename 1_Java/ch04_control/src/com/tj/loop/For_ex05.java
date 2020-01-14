package com.tj.loop;
// break vs. continue 
public class For_ex05 {
	public static void main(String[] args) {
		for(int i=1 ; i<=10 ; i++) {
			if(i==3) {
				//break; 아예 빠져나감
				continue; // if 조건만 출력 안하고, 다시 위로 올라감
			}
			System.out.println(i);
		}

	}

}
