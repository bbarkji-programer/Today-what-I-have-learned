package strategy3.modularization;

import strategy3.inter.GetStudentPay;
import strategy3.inter.JobStudy;

public class Student extends Person {

	private String ban;
	
	public Student(String id, String name, String ban) {
		super(id,name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print("\t(¹Ý)"+ban+"\n");
	}
	
}
