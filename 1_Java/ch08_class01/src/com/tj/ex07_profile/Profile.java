package com.tj.ex07_profile;

public class Profile {
	//필요데이터
		private String name;
		private int age;
		private char sex;
		
		//default 생성자(=매개 변수 없는 생성자)
		public Profile() {		
		}

		//3가지 정보 모두 나오는 생성자
		public Profile(String name, int age, char sex) {
			this.name = name;
			this.age = age;
			this.sex = sex;			
		}
		
		//기능메소드(출력해라)
		public void print() { // 프린트 하고 끝나는 거라 리턴값 필요X -> void
			System.out.println("이름 = "+name+", 나이 = "+age+", 성별 = "+sex);
		}
		
		//setter, getter
		//name
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		//age
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		//sex
		public char getSex() {
			return sex;
		}
		public void setSex(char sex) {
			this.sex = sex;
		}		
}
