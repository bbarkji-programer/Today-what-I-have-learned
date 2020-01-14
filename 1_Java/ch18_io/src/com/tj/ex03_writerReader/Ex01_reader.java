package com.tj.ex03_writerReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // ��Ʈ������.
			while(true) {
				int i = reader.read(); // 2byte�� �д´�.
				if(i==-1) break; // i=-1 ������ ������.
				System.out.print((char)i); // i�� �ƽ�Ű�ڵ�� ����� ��������� char�� ����ȯ
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(reader!=null)
					reader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
