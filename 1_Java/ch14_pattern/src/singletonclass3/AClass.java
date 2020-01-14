package singletonclass3;

public class AClass {

	private int intVar;
	private static AClass INSTANCE = new AClass();
	
	public static AClass getInstance() {
		return INSTANCE;		
	}
	private AClass() {
	}
	public int getIntVar() {
		return intVar;
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
}
