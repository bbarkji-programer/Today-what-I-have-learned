package com.tj.ex08_toy;

public class ToyMain {

	public static void main(String[] args) {
		
		IToy bear = new Bear();
		IToy mazinger = new Mazinger();
		IToy airplane = new Airplane();
			
//		IToy[] toy = {new Bear(), 
//				      new Mazinger(), 
//				      new Airplane()};		
		
		IToy[] toy1 = {bear, mazinger, airplane};
		for(IToy t : toy1) {
			System.out.println(t.getClass().getName());
		}
	}
}
