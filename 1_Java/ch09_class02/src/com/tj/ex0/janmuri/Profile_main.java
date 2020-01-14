package com.tj.ex0.janmuri;

class Profile {
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


public class Profile_main {
	public static void main(String[] args) {
		
		//구냥
//		Profile man = new Profile("홍길동", 20, 'm');
//		Profile woman = new Profile();
//			woman.setName("홍길순");
//			woman.setAge(19);
//			woman.setSex('f');
//		
//		man.print();
//		woman.print();

		// ★배열 함수 활용하는 경우(1) -> 동질 자료형을 반복할 때 활용하면 좋댱
		Profile[] man = { new Profile("홍길동", 20, 'm'),
		                  new Profile("홍길순", 19, 'f')
		};
		for(Profile m : man) {
			m.print(); // 일반구문
		}
		for(int idx=0 ; idx<man.length ; idx++) {
			man[idx].print(); // 확장구문
		}
		
		// ☆배열을 활용하는 경우(2)
		Profile[] person = new Profile[2];
		person[0] = new Profile("홍길동", 20, 'm');
		person[1] = new Profile("홍길순", 19, 'f');
		for(Profile p : person) {
			p.print();
		}
	}
}
