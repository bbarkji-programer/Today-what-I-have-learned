package com.tj.q01;
// static �̿��� ��ȣ�ű�, infoString() �޼ҵ� �߰�
public class Student {

		//����
		public static int count = 0;
		private int no;
	    private String name;
		private int kor;
		private int eng;
		private int mat;
		private int tot;
		private int avg;
		
		//������
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
		
		//��� �޼ҵ�
		public String infoString() { // infoString()�޼ҵ� �߰�
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
