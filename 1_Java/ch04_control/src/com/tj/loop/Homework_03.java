package com.tj.loop;
// 두 개의 주사위를 던졌을 때, 두수의 합이 6이되는 경우를 출력
public class Homework_03 {
	public static void main(String[] args) {
		for(int i=1 ; i<=6 ; i++) {
			for(int j=1 ; j<=6 ; j++) {
				if(i+j == 6) {
					System.out.println("i주사위: "+i+", j주사위: "+j);
				}//if
			}//for-j
		}//for-i
	}//main
}//class
