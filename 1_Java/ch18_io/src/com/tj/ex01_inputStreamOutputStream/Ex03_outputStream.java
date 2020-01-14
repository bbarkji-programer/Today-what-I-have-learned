package com.tj.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("D:/mega_IT/outTest.txt"); // FileOutputStream -> ������ ����. ������ ���� ��� ������.
			byte[] bs = {'H','E','L','L','O',',','J','A','V','A','\r','\n','H','I'};
			for(int i=0 ; i<bs.length ; i++) {
				os.write(bs[i]);
				System.out.println((char)bs[i]);
			}
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
