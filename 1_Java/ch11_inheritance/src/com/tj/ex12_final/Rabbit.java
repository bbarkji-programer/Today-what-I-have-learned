package com.tj.ex12_final;

public final class Rabbit extends Animal{
	
	@Override
	public void running() {
		speed += 30;
		System.out.println("±øÃÑ ±øÃÑ ¶Ù¾î¿ä. ÇöÀç ¼Óµµ´Â "+speed+"km/s");
	}
}
