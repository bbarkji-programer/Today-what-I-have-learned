package singletonclass2;

public class FirstClass {

	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("�̱��� ��ü�� i ��: "+singletonObject.getI());
		singletonObject.setI(200);
		System.out.println("�̱��� ��ü�� ���� �� i ��: "+singletonObject.getI());
		
	}
}
