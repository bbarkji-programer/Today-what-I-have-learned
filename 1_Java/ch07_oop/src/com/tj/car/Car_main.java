package com.tj.car;
          
public class Car_main {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("red");
		System.out.println(myPorsche.getColor());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("grey");
		Car hisPorsche = yourPorsche;
		System.out.println(yourPorsche.getColor());

	}
}
