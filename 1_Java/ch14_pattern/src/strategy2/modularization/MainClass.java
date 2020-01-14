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
		System.out.println("������������������������ �䱸���� ���� �����������������������");
		car[1].setFuel(new FuelHybrid()); // �ҳ�Ÿ�� ���ָ� -> ���̺긮�� 
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
