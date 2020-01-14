package com.tj.q01;

public class MainClass {
	public static void main(String[] args) {
		
		Employee[] employee = { 
				new SalaryEmployee("홍길동", 24000000),
				new SalaryEmployee("강동원", 70000000),
				new SalaryEmployee("김고은", 12000000),
				new HourlyEmployee("홍길구", 100, 7000),
				new HourlyEmployee("김길자", 120, 8000),
				};
		
		for(Employee temp : employee) {

			System.out.println("~ ~ ~ 월급명세서 ~ ~ ~");
			System.out.println("성  함: "+temp.getName());
			System.out.println("월  급: "+temp.computePay()+"원");
			
			int tempIncen = temp.computeIncentive();
			if(tempIncen!=0) {
				System.out.println("상  여: "+tempIncen+"원");
			}
			System.out.println("수 고 하 셨 습 니 다.");
		}
	}
}
