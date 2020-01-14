package com.tj.ex05_car;

import com.tj.cons.CarSpecs;
	
public class MainClass {
	public static void main(String[] args) {

	Car lowCar = new LowGradeCar(CarSpecs.COLOR_GREY, CarSpecs.TIRE_NORMAL,
						CarSpecs.DISPLACEMENT_1500, CarSpecs.HANDLE_POWER);
	Car highCar = new LowGradeCar(CarSpecs.COLOR_RED, CarSpecs.TIRE_WIDE,
			CarSpecs.DISPLACEMENT_2200, CarSpecs.HANDLE_POWER);
	lowCar.getSpec();
	highCar.getSpec();
	}
}
