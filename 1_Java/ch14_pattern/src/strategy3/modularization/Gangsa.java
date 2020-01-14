package strategy3.modularization;

import strategy3.inter.GetSalary;
import strategy3.inter.JobLec;

public class Gangsa extends Person {

	private String subject;
	
	public Gangsa(String id, String name, String subject) {
		super(id,name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());	
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print("\t(°ú¸ñ)"+subject+"\n");
	}
}
