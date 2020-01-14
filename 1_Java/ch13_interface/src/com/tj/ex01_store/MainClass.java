package com.tj.ex01_store;

public class MainClass {
	public static void main(String[] args) {

		Store1 s1 = new Store1();
		System.out.println(s1.getStr());
		s1.kimchi();
		s1.budai();
		s1.bibib();
		s1.sundai();
		s1.gongibab();
		
		Store2 s2 = new Store2();
		System.out.println(s2.getStr());
		s2.kimchi();
		s2.budai();
		s2.bibib();
		s2.sundai();
		s2.gongibab();
		
		Store3 s3 = new Store3();
		System.out.println(s3.getStr());
		s3.kimchi();
		s3.budai();
		s3.bibib();
		s3.sundai();
		s3.gongibab();
		System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�");
				
		HeadQuarterStore[] storeArr = {new Store1(),
									   new Store2(),
									   new Store3()
									   };
		
		for(HeadQuarterStore store : storeArr) {
			if(store instanceof Store1) {
				System.out.println(((Store1)store).getStr());
			}else if(store instanceof Store2) {
				System.out.println(((Store2)store).getStr());
			}else if(store instanceof Store3) {
				System.out.println(((Store3)store).getStr());
			}
			store.kimchi();
			store.budai();
			store.bibib();
			store.sundai();
			store.gongibab();
		}
	}
}
