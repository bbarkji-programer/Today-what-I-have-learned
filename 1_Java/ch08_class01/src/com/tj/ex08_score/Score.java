package com.tj.ex08_score;

public class Score {
	// 필요데이터
		private String name;
		private int kor;
		private int eng;
		private int mat;
		private int tot;
		private double avg;
	
	// default 생성자
		public Score() {
			
		}
	// 이름,과목,성적,합계,총점 다 입력하는 생성자
		public Score(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;

		}		
	// 기능메소드
		public void total() {
			kor+=eng+=mat;
		}
		public void average() {
			tot/=3;
		}
		public void print() {
			System.out.printf("성적표"+"\n"+"-------------------------------------------\n"+"이름\t 국어\t 영어\t 수학\t 총점\t 평균\n"+"-------------------------------------------\n"+"name"+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg);
		}
	// setter, getter
		//name
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		//kor
		public int getKor(int kor) {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		//eng
		public int getEng(int eng) {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		//mat
		public int getMat(int mat) {
			return mat;
		}
		public void setMat(int mat) {
			this.mat = mat;
		}
		
}
