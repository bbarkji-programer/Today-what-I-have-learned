package com.tj.ex01_string;

import java.util.Scanner;

public class FriendMain {

	public static void main(String[] args) {
		
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999","12-01"), 
									new Friend("��浿", "010-8888-8888", "11-01"),
									new Friend("�ű浿", "010-9999-8888", "01-08")};
		Scanner scanner = new Scanner(System.in);
		boolean searchOk = false; // �ѷȴ��� �Ȼѷȴ��� Ȯ�ο� (�ѷǴٸ� true�� �ǰ�. 
		String searchTel;
		
		System.out.println("�˻��ϰ��� �ϴ� ģ���� ��ȭ��ȣ ���ڸ���?");
		searchTel = scanner.next();
		for(Friend friend : friends) { // �迭�� ���� �ٲٴ°� �ƴϴϱ� Ȯ�屸�� ����
//			String tel = friend.getTel().substring(friend.getTel().lastIndexOf('-')+1);
			String tel = friend.getTel();
			String postTel = tel.substring(tel.lastIndexOf('-')+1);
			if(postTel.equals(searchTel)) {
				System.out.println(friend.infoString());
				searchOk = true;
			}
		}
		if(!searchOk) { // searchOk�� true��...? // for ���� true�� ��쿡�� if���� ���� false�� �Ǵϱ� �Ʒ� ������ ���� �ȵ�.
			System.out.println("�Է��Ͻ� ��ȭ��ȣ ���ڸ��� ���� ģ���� �����ϴ�.");
		}
		scanner.close();
		}
	}

