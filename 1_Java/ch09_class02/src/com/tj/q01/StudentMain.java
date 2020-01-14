package com.tj.q01;

// 객체 배열을 이용한 확장 for문
public class StudentMain {
	public static void main(String[] args) {
		// 변수 선언
		Student s1 = new Student("정우성", 90, 80, 95);
		Student s2 = new Student("김하늘", 100, 80, 95);
		Student s3 = new Student("황정민", 95, 80, 90);
		Student s4 = new Student("강동원", 95, 90, 99);
		Student s5 = new Student("유아인", 90, 90, 90);

		Student[] student = new Student[5];
		student[0] = s1;
		student[1] = s2;
		student[2] = s3;
		student[3] = s4;
		student[4] = s5;
		String[] title = {"번호", " 이름", " 국어", " 영어", " 수학", " 총점", " 평균"};
		int[] tot = new int[5];
		int[] avg = new int[5];
		
		//실행
		line();
		System.out.println("\t\t\t성 적 표");
		line('-',55);
		for(String t : title) {
			System.out.print(t+"\t");
		}
		System.out.println();
		line('-',55);
		for(Student s : student) {
			System.out.println(s.infoString());
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg();					
		}
		for(int idx=0 ; idx<avg.length ; idx++ ) {
			avg[idx] = tot[idx] / student.length;
		}
		line('-',55);
		System.out.print("\t 총점");
		for(int t : tot) {
			System.out.printf("\t%3d",t);
		}
		System.out.print("\n\t 평균");
		for(int a : avg) {
			System.out.print("\t"+ a);
		}
		System.out.println();
		line();

	}//main
	//줄바꿈 메소드
	private static void line() {
		for(int i=0 ; i<55 ; i++) {
			System.out.print('■');
		}
		System.out.println(); // 개행
	}
	private static void line(char ch, int cnt) {
		for(int i=0 ; i<cnt ; i++) {
			System.out.print(ch);
		}
		System.out.println();// 개행
	}
	
	
	
}
