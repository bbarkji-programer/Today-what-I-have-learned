package com.tj.ex03_writerReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 스트림연다.
			while(true) {
				int i = reader.read(); // 2byte씩 읽는다.
				if(i==-1) break; // i=-1 파일이 끝났다.
				System.out.print((char)i); // i는 아스키코드라서 제대로 보고싶으면 char로 형변환
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
