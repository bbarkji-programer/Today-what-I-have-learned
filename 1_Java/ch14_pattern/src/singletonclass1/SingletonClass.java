package singletonclass1;

public class SingletonClass {

	private int i;
	private static SingletonClass INSTANCE = new SingletonClass();
	private SingletonClass() {
	}
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i =i;
	}
}
//	
//	private static SingletonClass INSTANCE; // = null
//	
	// 객체 생성이 안되어 있으면 생성하고
	// 객체가 이미 생성된 게 있으면, 그 객체의 주소를 리턴한다.
//		if(INSTANCE==null) {
//			INSTANCE = new SingletonClass();
//		}
