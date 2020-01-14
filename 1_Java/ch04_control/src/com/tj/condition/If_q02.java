package com.tj.condition;
//두 수 중 큰 수를 변수 max에 입력하고 변수 max를 출력하는 프로그램입니다. 잘못된 부분은?
public class If_q02 {
	public static void main(String[] args) {
			int num1 = 27; // 변수선언
			int num2 = 32;
			int max; // 변수 선언을 { } 안에서 하면, 그 안에서만 유효하다. 그래서 웬만하면 변수 선언은 따로 위에 하는 것이... (if문 안에서 안하고)
			if(num1>num2){
				max = num1; 
			} else {
				max = num2;
			}
			System.out.println(max);
	}
}
	
