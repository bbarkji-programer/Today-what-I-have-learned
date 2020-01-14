package com.tj.ex;

public class Var_ex08 {
	public static void main(String[] args) {
	double 국어 = 80.5;
	System.out.println("국어 = "+90.5);
	double 영어 = 85.5;
	System.out.println("영어 = "+87.5);
	double 수학 = 94.5;
	System.out.println("수학 = "+95.0);
	double 총점 = (국어+영어+수학);
			System.out.printf("총점 = %5.2f\n",(국어+영어+수학));
	double 평균 = (double)(총점/3);
	System.out.printf("평균 = %5.2f\n",(총점/3));
	
	int value = 10;
	int sum =value + 20;
	System.out.println("합 : "+sum);
	
	double dd = 75.555555;
	double sum2 = dd + 20;
	System.out.println("합2 : "+sum2);
	
	}
}
