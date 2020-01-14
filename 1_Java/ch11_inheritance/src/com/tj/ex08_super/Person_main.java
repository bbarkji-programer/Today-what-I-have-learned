package com.tj.ex08_super;

public class Person_main {
	public static void main(String[] args) {
		
		Person papa = new Person();
		papa.setName("¾Æºü °õ");
		papa.setCharacter("¶×¶×ÇØ~");
		papa.intro();
		
		Person mom = new Person("¾ö¸¶ °õ", "³¯¾ÀÇØ~");
		mom.intro();
		
		Baby child1 = new Baby();
		child1.setName("¾Æ±â °õ");
		child1.setCharacter("³Ê¹« ±Í¿©¿ö~");
		child1.intro();
		
		System.out.println("***********************");
		Baby child2 = new Baby("¾Æ±â °õ2", "³Ê¹«³Ê¹«³Ê¹« ±Í¿©¿ö!");
		child2.intro();
	}
}
