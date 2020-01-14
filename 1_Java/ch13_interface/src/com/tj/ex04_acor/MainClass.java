package com.tj.ex04_acor;

public class MainClass {

		public static void main(String[] args) {
			
//			Amodel a = new Amodel(); 이렇게 쓰기 보다는
//			IAcor a = new Amodel(); 인터페이스 객체 이름을 쓴다. 
			
			IAcor[] models = {new Amodel(), new Bmodel(),
								new Cmodel()};
			
			for(IAcor model : models) {
				model.dmbReceive();
				model.lte();
				model.tvremoteControl();
				System.out.println("------------------");
			}
	}
}

