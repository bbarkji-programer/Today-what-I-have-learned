package com.tj.ex01_student;

// ��  ��  90 90 90 270 90.0 ������� ���~
public class Student {

	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;

	// main �Լ����� Student s = new Student(); �̷��� ���ڴ�. -> �ϴ� ����� �θ� ����.����Ҷ�
	public Student() {

	}

	// main �Լ����� Student s = new Student("�� ��", 90, 90, 90); �̷��� ���ڴ�.
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0;
	}

	// s.print() -> �� �� 90 90 90 270 90.0 ��� �̷��� �� ���ΰ�?
	public void print() { // <- ������ �ʿ� ������ void
		System.out.printf("\t %s \t %d \t %d \t %d \t %d \t %.1f\n", 
							name, kor, eng, mat, tot, avg);
	}

	// System.out.println(s.infoString()); <- ������ infoString() �̰� ���� ����.
	public String infoString() { // <- �����ؾ� �ϴϱ� void�� ���� ����.
		String result = String.format("\t %s \t %d \t %d \t %d \t %d \t %.1f\n", 
										name, kor, eng, mat, tot, avg);
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

	public double getAvg() {
		return avg;
	}
}
