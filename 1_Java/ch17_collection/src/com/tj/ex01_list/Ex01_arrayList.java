package com.tj.ex01_list;

import java.util.ArrayList;

public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3]; // ��Ʈ�� �迭
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		array[1] = "1111";
		for(int idx=0 ; idx<array.length; idx++) {
			System.out.println(idx+"��° "+array[idx]);
		}
//		for(String a : array) {
//			System.out.println(a);
//		}
		ArrayList<String> arrayList = new ArrayList<String>(); // ��Ʈ�� arrayList
		arrayList.add("str0"); // 0�� �ε���
		arrayList.add("str1"); // 2�� �ε���
		arrayList.add("str2"); // 3�� �ε��� 
		arrayList.add("str1"); // �ߺ� ��� 
		arrayList.add(1,"str11111111"); // 1�� �ε���
		arrayList.set(1,"1111111"); // ������ ����
		for(int idx=0 ; idx<arrayList.size(); idx++) {
			System.out.println(idx+"��° "+arrayList.get(idx));
		}
//		for(String a : arrayList) {
//			System.out.println(a);
//		}
		arrayList.remove(1); // 3�� �ε��� arrayList ����
		System.out.println(arrayList);
		arrayList.clear(); // arrayList�� ��� �����͸� ����
		if(arrayList.isEmpty()) {
			System.out.println("arrayList.clear()��");
		}
		arrayList = null;
		arrayList.add("str");
		
	}
}
