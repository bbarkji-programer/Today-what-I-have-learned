package com.tj.q01;
// static 이용한 번호매김, infoString() 메소드 추가
public class Student {

		//정보
		public static int count = 0;
		private int no;
	    private String name;
		private int kor;
		private int eng;
		private int mat;
		private int tot;
		private int avg;
		
		//생성자
		public Student() {
			
		}
		public Student(String name, int kor, int eng, int mat) {
			no = ++count;
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
			tot = kor + eng + mat;
			avg = tot / 3;
		}
		
		//기능 메소드
		public String infoString() { // infoString()메소드 추가
			String result = String.format("%d \t %s \t %d \t %d \t %d \t %d \t %d\n",
											no, name, kor, eng, mat, tot, avg);
			return result;
		}
		public String getName() {
			return name;
		}
		public int getKor() {
			return kor;
		}
		public int getEng() {
			return eng;
		}
		public int getMat() {
			return mat;
		}
		public int getTot() {
			return tot;
		}
		public int getAvg() {
			return avg;
		}

		
		
}
