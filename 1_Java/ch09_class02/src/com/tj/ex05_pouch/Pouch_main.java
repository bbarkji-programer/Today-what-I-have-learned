package com.tj.ex05_pouch;

public class Pouch_main {
	public static void main(String[] args) {
		
		Child first = new Child("Ã¹Â°");
		Child second = new Child("µÑÂ°");
		Child third = new Child("¼ÂÂ°");		
		
		System.out.println("¾ö¸¶ Áö°© µ·: "+Pouch.money);		
		first.takeMoney(100);
		System.out.println("¾ö¸¶ Áö°© µ·: "+Pouch.money);
		second.takeMoney(100);
		System.out.println("¾ö¸¶ Áö°© µ·: "+Pouch.money);
		third.takeMoney(100);		

	}
}
