package com.tj.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1) 스트림연다. 2) 읽는다. 3) 닫는다.
public class Ex02_inputStream3byte {
	public static void main(String[] args) {
		InputStream is = null; // InputStream 은 추상클래스.
		try {
			is = new FileInputStream("D:/mega_IT/inTest.txt"); // 1)스트림연다.
			byte[] bs = new byte[3]; 
			while(true) {
				int readByteCount = is.read(bs); // 2) 읽는다. - 3byte 씩 읽는다.
				if(readByteCount == -1) break;
				for(int i=0 ; i<readByteCount ; i++) {
					System.out.print((char)bs[i]);
				}
			}
//				for(byte b : bs)
//					System.out.print((char)b); // 이렇게 하면 맨 마지막에 읽는 것이 이상할 수 있음.(3byte씩 뿌리라고 했는데 마지막에 3byte가 모자랄 경우 앞에 문자 같이 출력..)
		
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
