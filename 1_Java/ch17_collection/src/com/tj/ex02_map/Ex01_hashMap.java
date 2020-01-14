package com.tj.ex02_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex01_hashMap {
	public static void main(String[] args) {
		
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(new Integer(0), "str0");
		hashmap.put(1, "str1");
		hashmap.put(2, "str2");
		hashmap.put(3, "str3");
//		hashmap.put(2, "str22"); // Ű ���� �����ؾ� �Ѵ�. �����Ͱ� �������.
		System.out.println(hashmap.get(2));
		System.out.println("remove �� : "+hashmap);
		hashmap.remove(2); // Ư���� Ű �� ����
		System.out.println("remove �� : "+hashmap);
		hashmap.put(2, "2222");
		hashmap.clear();
		System.out.println("clear�� : "+hashmap);
		hashmap.put(0,"hong gil dong");
		hashmap.put(1,"kim dong il");
		hashmap.put(2, "Yu ain");
		hashmap.put(3, "Lee soonsin");
		
		System.out.println(hashmap);
		
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key+": "+hashmap.get(key));
		}
		
	}
}
