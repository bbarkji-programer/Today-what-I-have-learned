package com.tj.ex04_bufferedReaderBufferedWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex02_keyboard {
	public static void main(String[] args) {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드 엔터 나올때까지 스트림으로 파일이름을 받음
		Reader reader = null; // 기본 스트림
		BufferedReader br = null; // 보조 스트림
		
		System.out.print("읽어올 파일 이름은? ");
		try {
			String filename = keyboard.readLine(); // 파일이름 입력
			File file = new File(filename); // 입력된 파일 이름으로 파일객체 생성
			if(file.exists()) { // 존재하는 파일
				reader = new FileReader(file); // 기본스트림 연다
				br = new BufferedReader(reader); // 기본 스트림 통해 보조스트림 연다. 한 줄씩 읽는다.
				while(true) {
					String linedata = br.readLine();
					if(linedata==null)break; // 파일의 끝~ -> 이면 끝내
					System.out.println(linedata);
				}
			}else {
				System.out.println("입력하신 파일은 존재하지 않아 읽을 수 없습니다.");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br!=null) br.close();
				if(reader!=null) reader.close();
				if(keyboard!=null) keyboard.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
