package com.tj.ex01_list;

import java.util.ArrayList;

public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3]; // 스트링 배열
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		array[1] = "1111";
		for(int idx=0 ; idx<array.length; idx++) {
			System.out.println(idx+"번째 "+array[idx]);
		}
//		for(String a : array) {
//			System.out.println(a);
//		}
		ArrayList<String> arrayList = new ArrayList<String>(); // 스트링 arrayList
		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 2번 인덱스
		arrayList.add("str2"); // 3번 인덱스 
		arrayList.add("str1"); // 중복 허용 
		arrayList.add(1,"str11111111"); // 1번 인덱스
		arrayList.set(1,"1111111"); // 데이터 수정
		for(int idx=0 ; idx<arrayList.size(); idx++) {
			System.out.println(idx+"번째 "+arrayList.get(idx));
		}
//		for(String a : arrayList) {
//			System.out.println(a);
//		}
		arrayList.remove(1); // 3번 인덱스 arrayList 삭제
		System.out.println(arrayList);
		arrayList.clear(); // arrayList의 모든 데이터를 지움
		if(arrayList.isEmpty()) {
			System.out.println("arrayList.clear()됨");
		}
		arrayList = null;
		arrayList.add("str");
		
	}
}
