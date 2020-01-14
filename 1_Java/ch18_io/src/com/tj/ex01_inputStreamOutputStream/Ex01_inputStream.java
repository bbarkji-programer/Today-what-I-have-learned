package com.tj.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 파일(inTest.txt)로부터 입력받기 - Hello, java\r\nHi
// 1)스트림을 연다.
// 2)읽는다. 
// 3)파일을 *반드시 닫는다.  
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is=null;
		try {			
			is = new FileInputStream("D:/mega_IT/inTest.txt"); // 1)스트림을 연다.
			while(true) {
				int i = is.read(); // 2)읽는다.- 1byte씩 읽는다.
				if(i==-1) { // i가 -1 이면, 파일이 끝났다는 의미.
					break;
				}
				System.out.println((char)i+"의 아스키코드 값 : "+i); // 아스키코드를 char로 형변환.
			}
		} catch (FileNotFoundException e) { // 더 작은(?) 범위의 에러를 가장 위에 .
			System.out.print("파일을 못 찾는 경우 예외처리 "+e.getMessage());
		} catch (IOException e) {
			System.out.print("파일을 못 읽는 경우 예외처리 "+e.getMessage());
		} finally { 
			try {
				if(is!=null) is.close(); // 3)파일을 닫는다.
			} catch (IOException e) {
				System.out.print(e.getMessage());
			}
		}
	}
}
