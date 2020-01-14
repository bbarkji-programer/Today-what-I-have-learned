package com.tj.ex04_bufferedReaderBufferedWriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class Ex03_keyboard {
	public static void main(String[] args) {
		Writer writer = null;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������ ���� �̸���? ");
		try {
			String filename = keyboard.readLine();
			writer = new FileWriter(filename); // �Է��� ���� �̸����� ��Ʈ�� ����.(���� ������ �ڱⰡ ����)
			while(true) {
				System.out.print("���� ������?(�� �̻� �Է��ϰ� ���� ������ x�Է�)");
				String content = keyboard.readLine();
				if(content.equalsIgnoreCase("x")) break;
				writer.write(content+"\r\n");
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
				if(keyboard!=null) keyboard.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
