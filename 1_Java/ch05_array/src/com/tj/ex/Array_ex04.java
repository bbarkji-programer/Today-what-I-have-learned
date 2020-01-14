package com.tj.ex;

import java.util.Scanner;

// 배열을 이용하여 학생들(영희, 철수, 길동, 영수, 말자)의 키를 입력받고
// 가장 큰 학생과 가장 작은 학생을 구분해 보자.
public class Array_ex04 {
	public static void main(String[] args) {
		
		
		String[] arrName = {"영희","철수","길동","영수","말자"};
		int[] arrHeight = new int[5];
		Scanner scanner = new Scanner(System.in);
		//배열 만들기
		
		for(int idx=0 ; idx < arrName.length ; idx++) {
			System.out.println(arrName[idx]+"의 키는 ?");
			arrHeight[idx] = scanner.nextInt();	
		}//키 입력 받기
		
		scanner.close();
		
		int min = 9999; // 최소키
		int max = 0;    // 최대키
		int tot = 0;    // 키 누적
		int minIndex=-1, maxIndex=-1;
		
		for(int idx=0 ; idx < arrName.length ; idx++) {
			tot += arrHeight[idx]; // 키 누적
			
			if(arrHeight[idx]<min) {
				min = arrHeight[idx]; // 최소값이 min이 아니면, min으로 비교값을 수정
				minIndex = idx;
			}//if - 최소값 처리
			
			if(arrHeight[idx]>max) {
				max = arrHeight[idx];
				maxIndex = idx;
			}//if - 최대값 처리
				}
	    System.out.println("최장신키(이름): "+max+"("+arrName[maxIndex]+")");
		System.out.println("최단신키(이름): "+min+"("+arrName[minIndex]+")");
		System.out.printf("평균키: %.2f\n", (double)tot/arrName.length);
	}
}
