package com.tj.ex03_set;

import java.util.HashSet;

//set �� �ߺ��� ������� �ʴ´�.
public class Ex01_hashSet {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");
		hashSet.add("str1");
		hashSet.add("str2");
		hashSet.add("str2"); // �ߺ��� �ȵ�. �߰��� �ȵǴ� ����.
		System.out.println("size="+hashSet.size()); // size=3���� ����. �߰��� �ȵȴٴϱ�?
		System.out.println(hashSet);
		
	}

}
