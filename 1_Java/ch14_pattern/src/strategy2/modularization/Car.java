package strategy2.modularization;

import strategy2.inter.IEngine;
import strategy2.inter.IFuel;
import strategy2.inter.IKm;

public class Car {
	
	private IEngine engine;
	private IKm km;
	private IFuel fuel;
	
	public void drive() {
		System.out.println("drive �� �� �ֽ��ϴ�.");
	}
	public void shape() {
		System.out.println("�� ����� door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}
	public void isEngine() {
		engine.engine();
	}
	public void isKm() {
		km.kmPerLitter();
	}
	public void isFuel() {
		fuel.fuel();
	}
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}
	public void setKm(IKm km) {
		this.km = km;
	}
}
