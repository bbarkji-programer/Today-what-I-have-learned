package com.tj.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1) ��Ʈ������. 2) �д´�. 3) �ݴ´�.
public class Ex02_inputStream3byte {
	public static void main(String[] args) {
		InputStream is = null; // InputStream �� �߻�Ŭ����.
		try {
			is = new FileInputStream("D:/mega_IT/inTest.txt"); // 1)��Ʈ������.
			byte[] bs = new byte[3]; 
			while(true) {
				int readByteCount = is.read(bs); // 2) �д´�. - 3byte �� �д´�.
				if(readByteCount == -1) break;
				for(int i=0 ; i<readByteCount ; i++) {
					System.out.print((char)bs[i]);
				}
			}
//				for(byte b : bs)
//					System.out.print((char)b); // �̷��� �ϸ� �� �������� �д� ���� �̻��� �� ����.(3byte�� �Ѹ���� �ߴµ� �������� 3byte�� ���ڶ� ��� �տ� ���� ���� ���..)
		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
