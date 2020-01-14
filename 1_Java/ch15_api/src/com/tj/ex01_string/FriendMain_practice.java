package com.tj.ex01_string;

import java.util.Scanner;

public class FriendMain_practice {

	public static void main(String[] args) {
		
		Friend[] friends = {new Friend("ȫ�浿", "010-1111-2222", "12-01"),
							new Friend("��浿", "010-2222-3333", "11-01")};
		
		Scanner scanner = new Scanner(System.in);
		String searchTel;
		boolean searchOk = false;
		
		System.out.print("�˻��ϰ��� �ϴ� ��ȭ��ȣ ���ڸ���?");
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
			System.out.println("�Է��Ͻ� ��ȭ��ȣ ���ڸ��� ���� ģ���� �����ϴ�.");
		}
		scanner.close();
	}
}
