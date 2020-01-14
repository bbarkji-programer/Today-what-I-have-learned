package com.tj.ex01_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex04_linkedVSarray {
	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<String>();
		LinkedList<String> linkedlist = new LinkedList<String>();
		
		System.out.println("arraylist ������ �߰� �ð�: "+addSequenceTime(arraylist));
		System.out.println("linkedlist ������ �߰��ð�: "+addSequenceTime(linkedlist));
		System.out.println("arraylist ���� �߰��ð�: "+addRandomTime(arraylist));
		System.out.println("linkedlist ���� �߰��ð�: "+addRandomTime(linkedlist));
		System.out.println("arraylist ���� �����ð�: "+removeRandomTime(arraylist));
		System.out.println("linkedlist ���� �����ð�: "+removeRandomTime(linkedlist));
		System.out.println("arraylist ������ �����ð�: "+removeSequenceTime(arraylist));
		System.out.println("linkedlist ������ �����ð�: "+removeSequenceTime(linkedlist));
	}
	private static long removeSequenceTime(List<String>list) {
		long start = System.currentTimeMillis();
		for(int i=list.size()-1 ; i>1000 ; i--) {
			list.remove(i); // ������ index�� ���ʷ� ����
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	private static long removeRandomTime(List<String>list) {
		long start = System.currentTimeMillis();
		for(int i=0 ; i<1000 ; i++) {
			list.remove(0);
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	private static long addRandomTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0 ; i<1000 ; i++) {
			list.add(10, "���� �߰�");
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	private static long addSequenceTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0 ; i<5000000 ; i++) {
			list.add("������ �߰�");
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
}
