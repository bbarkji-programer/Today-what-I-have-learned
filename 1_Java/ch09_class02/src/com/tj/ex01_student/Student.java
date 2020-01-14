package com.tj.ex01_student;

// 공  유  90 90 90 270 90.0 양식으로 출력~
public class Student {

	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;

	// main 함수에서 Student s = new Student(); 이렇게 쓰겠다. -> 일단 만들어 두면 좋음.상속할때
	public Student() {

	}

	// main 함수에서 Student s = new Student("공 유", 90, 90, 90); 이렇게 쓰겠다.
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0;
	}

	// s.print() -> 공 유 90 90 90 270 90.0 출력 이렇게 할 것인가?
	public void print() { // <- 리턴할 필요 없으니 void
		System.out.printf("\t %s \t %d \t %d \t %d \t %d \t %.1f\n", 
							name, kor, eng, mat, tot, avg);
	}

	// System.out.println(s.infoString()); <- 실제로 infoString() 이걸 많이 쓴다.
	public String infoString() { // <- 리턴해야 하니까 void를 쓰지 않음.
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
