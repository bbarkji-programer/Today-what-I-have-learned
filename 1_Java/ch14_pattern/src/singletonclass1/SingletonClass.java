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
	// ��ü ������ �ȵǾ� ������ �����ϰ�
	// ��ü�� �̹� ������ �� ������, �� ��ü�� �ּҸ� �����Ѵ�.
//		if(INSTANCE==null) {
//			INSTANCE = new SingletonClass();
//		}
