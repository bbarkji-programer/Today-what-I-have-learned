package com.tj.ex03_set;

import java.util.HashSet;

//set 은 중복을 허용하지 않는다.
public class Ex01_hashSet {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");
		hashSet.add("str1");
		hashSet.add("str2");
		hashSet.add("str2"); // 중복은 안됨. 추가가 안되는 것임.
		System.out.println("size="+hashSet.size()); // size=3으로 나옴. 추가가 안된다니까?
		System.out.println(hashSet);
		
	}

}
