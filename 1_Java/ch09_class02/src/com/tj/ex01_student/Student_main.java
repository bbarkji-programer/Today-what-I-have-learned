package com.tj.ex01_student;

public class Student_main {
	public static void main(String[] args) {	
		//변수 선언
		Student s1 = new Student("공  유", 90, 90, 90);
		Student s2 = new Student("이민기", 81, 90, 90);
		Student s3 = new Student("이동욱", 91, 90, 90);
		Student s4 = new Student("강동원", 80, 90, 90);
		Student s5 = new Student("유아인", 70, 90, 90);
		Student[] student = new Student[5];
		student[0] = s1;
		student[1] = s2;
		student[2] = s3;
        student[3] = s4;
		student[4] = s5;
		String[] title = {"이름", "국어", "영어", "수학", "총점", "평균"};
		int[] tot = new int[5];
		double[] avg = new double[5]; // 모든 방은 0.0 초기화		
		//실행
		line(); // 두꺼운 라인 ■■■■■■■■
		System.out.println("\t\t\t\t성적표");		
		line('-',46); // 얇은 라인 -----------		
		for(String t : title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		line('-',46); // 얇은 라인 -----------		
		for(Student s : student) {
			//s.print();
			System.out.print(s.infoString()); // 한 객체 씩 출력 한 다음에
			tot[0] += s.getKor(); // tot[0] = tot[0] + s.getKor() 국어 누적
			tot[1] += s.getEng(); // 영어 누적
			tot[2] += s.getMat(); // 수학 누적
			tot[3] += s.getTot(); // 합계 누적
			tot[4] += s.getAvg(); // 평균 누적
		}
		// 배열 안을 조작할 때는 for 일반 구문만 사용
		for(int idx=0 ; idx<avg.length ; idx++) { // 평균 계산
			avg[idx] = tot[idx] / student.length;
		}
		line('-',46); // 얇은 라인 -----------
		System.out.print("\t총점");
		for(int t : tot) { // 확장 구문
			//System.out.print("\t"+t);
			System.out.printf("\t%4d", t);
		}
		System.out.print("\n\t평균");
		for(double a : avg) {
			System.out.print("\t"+a);
		}
		System.out.println();
		line(); // 두꺼운 라인 ■■■■■■■■
	}//main
	//메소드~
	private static void line() {
		for(int i=0 ; i<63 ; i++) {
			System.out.print('■');
		}
		System.out.println(); // 개행
	}
	private static void line(char ch, int cnt ) {
		System.out.print("\t");
		for(int i=0 ; i<cnt ; i++) { // 한 줄에 cnt번 ch를 출력
			System.out.print(ch);
		}
		System.out.println(); // 개행
	}	
}
