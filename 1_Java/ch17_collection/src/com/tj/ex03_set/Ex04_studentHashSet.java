package com.tj.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex04_studentHashSet {
	public static void main(String[] args) {
		HashSet<Student> hashset = new HashSet<Student>();
		Student h1 = new Student("È«±æµ¿",1);
		Student h2 = new Student("È«±æµ¿",1);
		System.out.println(h1.equals(h2));
		System.out.println(h1.hashCode());
		System.out.println(h2.hashCode());
		hashset.add(h1);
		hashset.add(h2);
		hashset.add(new Student("±è±æµ¿",1));
		hashset.add(new Student("¸¶±æµ¿",1));
		hashset.remove(h2);
		System.out.println(hashset);
		Iterator<Student> iterator = hashset.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
