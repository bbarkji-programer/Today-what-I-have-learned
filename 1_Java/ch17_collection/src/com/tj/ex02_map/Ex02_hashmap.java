package com.tj.ex02_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex02_hashmap {
	public static void main(String[] args) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("È«±æµ¿", "010-1111-0000");
		hash.put("±è±æµ¿", "010-2222-0000");
		hash.put("ÃÖ±æµ¿", "010-3333-0000");
		System.out.println(hash);
		
		Iterator<String> iterator = hash.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key+": "+hash.get(key));
		}
	}
}
