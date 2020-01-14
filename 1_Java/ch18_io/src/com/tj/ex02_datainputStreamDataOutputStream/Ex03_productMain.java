package com.tj.ex02_datainputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_productMain {
	public static void main(String[] args) {
		// 1�ܰ�. x�� �Է��� �� ���� ��� �Է�(���Ǹ�, ����, ������)�޾� ���Ͽ� ����
		Scanner scanner = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/product.dat",true);
			dos = new DataOutputStream(fos);
			do {
				System.out.print("��ǰ�� �� �ֳ���?(�ߴ��� ���ϸ� X, ��� �����Ϸ��� �ƹ� Ű�� ������~)");
				answer = scanner.next();
				if(answer.equalsIgnoreCase("x")) {
					break;
				}
				System.out.print("�Է��� ��ǰ�� ��ǰ����? ");
				dos.writeUTF(scanner.next());
				System.out.print("�Է��� ��ǰ�� ������? ");
				dos.writeInt(scanner.nextInt());
				System.out.println("�Է��� ��ǰ�� �����? ");
				dos.writeInt(scanner.nextInt());
			}while(true);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
