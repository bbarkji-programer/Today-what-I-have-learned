package com.tj.ex01_string;

import java.util.Scanner;

public class FriendMain {

	public static void main(String[] args) {
		
		Friend[] friends = {new Friend("홍길동", "010-9999-9999","12-01"), 
									new Friend("김길동", "010-8888-8888", "11-01"),
									new Friend("신길동", "010-9999-8888", "01-08")};
		Scanner scanner = new Scanner(System.in);
		boolean searchOk = false; // 뿌렸는지 안뿌렸는지 확인용 (뿌렷다면 true가 되게. 
		String searchTel;
		
		System.out.println("검색하고자 하는 친구의 전화번호 뒷자리는?");
		searchTel = scanner.next();
		for(Friend friend : friends) { // 배열의 값을 바꾸는게 아니니까 확장구문 가능
//			String tel = friend.getTel().substring(friend.getTel().lastIndexOf('-')+1);
			String tel = friend.getTel();
			String postTel = tel.substring(tel.lastIndexOf('-')+1);
			if(postTel.equals(searchTel)) {
				System.out.println(friend.infoString());
				searchOk = true;
			}
		}
		if(!searchOk) { // searchOk가 true면...? // for 문이 true인 경우에는 if안의 값이 false가 되니까 아래 문장이 실행 안됨.
			System.out.println("입력하신 전화번호 뒷자리를 갖는 친구는 없습니다.");
		}
		scanner.close();
		}
	}

