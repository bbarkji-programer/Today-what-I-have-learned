package com.tj.ex01_string;

import java.util.Scanner;

public class FriendMain_practice {

	public static void main(String[] args) {
		
		Friend[] friends = {new Friend("홍길동", "010-1111-2222", "12-01"),
							new Friend("김길동", "010-2222-3333", "11-01")};
		
		Scanner scanner = new Scanner(System.in);
		String searchTel;
		boolean searchOk = false;
		
		System.out.print("검색하고자 하는 전화번호 뒷자리는?");
		searchTel = scanner.next();
		for(Friend friend : friends) {
			String tel = friend.getTel();
			String posTel = tel.substring(tel.lastIndexOf('-')+1);
			if(posTel.contentEquals(searchTel)) {
				System.out.println(friend.infoString());
				searchOk = true;
			}		
		}
		if(!searchOk) {
			System.out.println("입력하신 전화번호 뒷자리를 가진 친구는 없습니다.");
		}
		scanner.close();
	}
}
