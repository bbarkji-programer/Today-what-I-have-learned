package com.tj.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1) 입력 스트림 연다. 출력 스트림 연다.
// 2) 읽은 데이터 그대로 write 한다. (파일 끝까지)
// 3) 입력 스트림과 출력 스트림을 닫는다.

public class FileCopyStep02 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/choi.jpg");
			os = new FileOutputStream("txtFile/choi_copy.jpg"); // copy할 파일 제목. (없으면 새로 만든다.)
			int cnt = 0;
			byte[] bs = new byte[1024]; // 1K씩 가져오기
			while(true) {
				cnt++;
				int readByteCount = is.read(bs); // (10K)1024byte 씩 읽고
				if(readByteCount==-1) { // i가 -1이 될때까지(=파일이 끝날때까지)
					break;
				}os.write(bs,0,readByteCount); // bs 배열의 0인덱스부터 readByteCount 바이트 만큼 쓴다.
			}
			System.out.println("파일 카피 완료. while문 몇번 돌았는지 : "+cnt);
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
