package com.tj.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt"); 
			// FileOutputStream -> ������ ����. ������ ���� ��� ������. ������ ��������°� ������, ',true'�� ġ�� ��. <- append(�߰���)
			String str = "�ȳ��ϼ���.\r\n�ݰ����ϴ�.\r\n�ȳ�";
			byte[] bs = str.getBytes(); // byte �迭�� ������ִ� ��. {'H','E','L','L','O',',','J','A','V','A','\r','\n','H','I'};			
			os.write(bs);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage()); // ������ ���� ��� ���� �߻�
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
			if(os!=null)
					os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
