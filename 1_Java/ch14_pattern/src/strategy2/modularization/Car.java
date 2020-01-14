package strategy2.modularization;

import strategy2.inter.IEngine;
import strategy2.inter.IFuel;
import strategy2.inter.IKm;

public class Car {
	
	private IEngine engine;
	private IKm km;
	private IFuel fuel;
	
	public void drive() {
		System.out.println("drive 할 수 있습니다.");
	}
	public void shape() {
		System.out.println("차 모양은 door, sheet, handle로 이루어져 있습니다.");
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
