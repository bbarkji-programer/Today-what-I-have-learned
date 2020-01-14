package strategy3.modularization;

import strategy3.inter.GetSalary;
import strategy3.inter.JobMng;

public class Staff extends Person {

	private String part;
	
	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print("\t(ºÎ¼­)"+part+"\n");
	}
}
