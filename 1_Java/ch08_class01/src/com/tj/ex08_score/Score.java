package com.tj.ex08_score;

public class Score {
	// �ʿ䵥����
		private String name;
		private int kor;
		private int eng;
		private int mat;
		private int tot;
		private double avg;
	
	// default ������
		public Score() {
			
		}
	// �̸�,����,����,�հ�,���� �� �Է��ϴ� ������
		public Score(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;

		}		
	// ��ɸ޼ҵ�
		public void total() {
			kor+=eng+=mat;
		}
		public void average() {
			tot/=3;
		}
		public void print() {
			System.out.printf("����ǥ"+"\n"+"-------------------------------------------\n"+"�̸�\t ����\t ����\t ����\t ����\t ���\n"+"-------------------------------------------\n"+"name"+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg);
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
