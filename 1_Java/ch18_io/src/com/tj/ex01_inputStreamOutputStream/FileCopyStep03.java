package com.tj.ex01_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1) 입력 스트림 연다. 출력 스트림 연다.
// 2) 읽은 데이터 그대로 write 한다. (파일 끝까지)
// 3) 입력 스트림과 출력 스트림을 닫는다.

public class FileCopyStep03 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		File file = new File("txtFile/choi.jpg"); // 파일에 대한 정보를 가져온다.
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream("txtFile/choi_copy.jpg");
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()]; // 파일의 크기만큼 가져오기. 파일 크기가 long 형이니까 int로 형 변환 필요.
			while(true) {
				cnt++;
				int readByteCount = is.read(bs); 
				if(readByteCount==-1) { 
					break;
				}os.write(bs,0,readByteCount); 
			}
			System.out.println("파일 카피 완료. while문 몇번 돌았는지 : "+cnt); /// 2번 돌고 1번 쓴다.
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음"+e.getMessage());
		} catch (IOException e) {
			System.out.println("읽기 예외"+e.getMessage());
		} finally {
			try {
				if(os!=null) {
					os.close();
				}
				if(is!=null) {
					is.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
