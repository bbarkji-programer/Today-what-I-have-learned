package com.tj.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// ����(inTest.txt)�κ��� �Է¹ޱ� - Hello, java\r\nHi
// 1)��Ʈ���� ����.
// 2)�д´�. 
// 3)������ *�ݵ�� �ݴ´�.  
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is=null;
		try {			
			is = new FileInputStream("D:/mega_IT/inTest.txt"); // 1)��Ʈ���� ����.
			while(true) {
				int i = is.read(); // 2)�д´�.- 1byte�� �д´�.
				if(i==-1) { // i�� -1 �̸�, ������ �����ٴ� �ǹ�.
					break;
				}
				System.out.println((char)i+"�� �ƽ�Ű�ڵ� �� : "+i); // �ƽ�Ű�ڵ带 char�� ����ȯ.
			}
		} catch (FileNotFoundException e) { // �� ����(?) ������ ������ ���� ���� .
			System.out.print("������ �� ã�� ��� ����ó�� "+e.getMessage());
		} catch (IOException e) {
			System.out.print("������ �� �д� ��� ����ó�� "+e.getMessage());
		} finally { 
			try {
				if(is!=null) is.close(); // 3)������ �ݴ´�.
			} catch (IOException e) {
				System.out.print(e.getMessage());
			}
		}
	}
}
