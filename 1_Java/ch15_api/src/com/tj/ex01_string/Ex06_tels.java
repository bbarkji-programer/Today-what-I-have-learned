package com.tj.ex01_string;

import java.util.Scanner;

// substring() lastIndexOf()
public class Ex06_tels {

	public static void main(String[] args) {
		
		String[] tels = {"010-1111-1111", "010-1111-2222", "010-2222-2222", "010-3333-2222"};
		Scanner scanner = new Scanner(System.in);
		String searchTel;
		int idx;
		boolean searchOk = false; // 검색한 결과가 있으면 true (기본적으로는 false로 초기화)
		
		System.out.println("검색하고자 하는 회원의 전화번호 뒷자리는? ");
		searchTel = scanner.next(); // 스페이스가 있음 안된당
		for(idx=0 ; idx<tels.length ; idx++) {	
			String temp = tels[idx].substring(tels[idx].lastIndexOf('-')+1 );// 전화번호 뒷자리 빼내기 : (마지막 '-'의 인덱스+1(다음))부터 출력해
			if(temp.equals(searchTel)) {
				System.out.println("검색하신 전화번호는 "+tels[idx]);
				searchOk = true ; // 찾았다.
			}
		}
		if(!searchOk) { // searchOk가 false가 아니면 = true면?
			System.out.println("검색하신 전화번호는 없습니다.");
		}
		
		scanner.close();
	}
}
