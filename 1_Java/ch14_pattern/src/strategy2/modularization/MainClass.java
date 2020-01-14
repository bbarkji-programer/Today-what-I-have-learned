package strategy2.modularization;

import strategy2.inter.FuelHybrid;

public class MainClass {

	public static void main(String[] args) {
		
		Car[] car = {new Genesis(), new Sonata(), new Accent()};
		for(Car c : car) {
			System.out.println("================================================");
			c.shape();
			c.drive();
			c.isEngine();
			c.isFuel();
			c.isKm();
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■ 요구사항 변경 ■■■■■■■■■■■■■■■■■■■■■■");
		car[1].setFuel(new FuelHybrid()); // 소나타를 가솔린 -> 하이브리드 
		for(Car c : car) {
			System.out.println("================================================");
			c.shape();
			c.drive();
			c.isEngine();
			c.isFuel();
			c.isKm();
		}
	}
}
