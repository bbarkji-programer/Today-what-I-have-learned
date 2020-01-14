package com.tj.ex07_profile;

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
