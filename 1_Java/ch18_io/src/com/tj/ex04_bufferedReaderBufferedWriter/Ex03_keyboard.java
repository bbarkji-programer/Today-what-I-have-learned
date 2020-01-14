package com.tj.ex04_bufferedReaderBufferedWriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class Ex03_keyboard {
	public static void main(String[] args) {
		Writer writer = null;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("저장할 파일 이름은? ");
		try {
			String filename = keyboard.readLine();
			writer = new FileWriter(filename); // 입력한 파일 이름으로 스트림 연다.(파일 없으면 자기가 만듬)
			while(true) {
				System.out.print("파일 내용은?(더 이상 입력하고 싶지 않으면 x입력)");
				String content = keyboard.readLine();
				if(content.equalsIgnoreCase("x")) break;
				writer.write(content+"\r\n");
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
				if(keyboard!=null) keyboard.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
