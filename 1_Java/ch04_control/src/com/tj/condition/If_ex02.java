package com.tj.condition;

public class If_ex02 {

	public static void main(String[] args) {
	
		int seoulLunchPrice = 4900; //변수 이름은 친절하게 딱 보고 알 수 있게(요즘 추세)
		
		if(seoulLunchPrice >7000) {
			System.out.println("점심 밥값이 비싸네요.");
		}else if(seoulLunchPrice >6000) {
			System.out.println("점심 밥값이 조금만 더 저렴했으면");
		}else if(seoulLunchPrice >=4000) {
			System.out.println("점심 밥값이 좋네요.");
		}else {
			System.out.println("뭐 나는 좋은데 식당은 망하지 않으려나?");
		}
	}

}
