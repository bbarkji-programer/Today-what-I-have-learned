package com.tj.homework;
// 국, 영, 수, 총점, 평균
public class Exam {
	public static void main(String[] args) {
		int kor = 98; // 선언과 동시에 초기화(할당)
		int eng = 100;
		int mat = 92;
		int tot = kor + eng + mat;
//		double avg = (double)tot / 3; // 명시적 형변환
		double avg = tot / 3.0; // 묵시적 형변환
		System.out.println("국어 : "+kor+"\t영어 : "+eng+"\t수학 : "+mat);
		System.out.printf("총점 : %d\t평균: %.2f\n", tot, avg);
}
}
