package com.tj.ex04_acor;

public class MainClass {

		public static void main(String[] args) {
			
//			Amodel a = new Amodel(); �̷��� ���� ���ٴ�
//			IAcor a = new Amodel(); �������̽� ��ü �̸��� ����. 
			
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

