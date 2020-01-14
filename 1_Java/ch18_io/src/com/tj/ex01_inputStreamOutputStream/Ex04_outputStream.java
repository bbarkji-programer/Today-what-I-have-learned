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
			// FileOutputStream -> 파일을 연다. 파일이 없는 경우 만들어낸다. 내용이 덮어씌워지는게 싫으면, ',true'를 치면 됨. <- append(추가됨)
			String str = "안녕하세요.\r\n반갑습니다.\r\n안녕";
			byte[] bs = str.getBytes(); // byte 배열로 만들어주는 애. {'H','E','L','L','O',',','J','A','V','A','\r','\n','H','I'};			
			os.write(bs);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage()); // 폴더가 없는 경우 에러 발생
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
