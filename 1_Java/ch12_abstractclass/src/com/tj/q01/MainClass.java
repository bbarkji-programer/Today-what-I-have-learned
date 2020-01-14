package com.tj.q01;

public class MainClass {
	public static void main(String[] args) {
		
		Employee[] employee = { 
				new SalaryEmployee("ȫ�浿", 24000000),
				new SalaryEmployee("������", 70000000),
				new SalaryEmployee("�����", 12000000),
				new HourlyEmployee("ȫ�汸", 100, 7000),
				new HourlyEmployee("�����", 120, 8000),
				};
		
		for(Employee temp : employee) {

			System.out.println("~ ~ ~ ���޸��� ~ ~ ~");
			System.out.println("��  ��: "+temp.getName());
			System.out.println("��  ��: "+temp.computePay()+"��");
			
			int tempIncen = temp.computeIncentive();
			if(tempIncen!=0) {
				System.out.println("��  ��: "+tempIncen+"��");
			}
			System.out.println("�� �� �� �� �� �� ��.");
		}
	}
}
