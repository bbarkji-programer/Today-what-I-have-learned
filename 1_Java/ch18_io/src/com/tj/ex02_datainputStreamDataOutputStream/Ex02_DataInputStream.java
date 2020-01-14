package com.tj.ex02_datainputStreamDataOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat"); // 기본 스트림 먼저 연다.
			dis = new DataInputStream(fis); // 보조스트림은 기본 스트림 통해 연다.
			String name = dis.readUTF();
			int grade = dis.readInt();
			double score = dis.readDouble(); // 입력한 값을 입력한 순서대로 쓴다.
			System.out.println("입력 받은 값은 : "+name+"\t"+grade+"\t"+score);
		} catch (FileNotFoundException e) {
			System.out.println("폴더 없음"+e.getMessage());	
		} catch (IOException e) {
			System.out.println("쓰기 예외"+e.getMessage());
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close(); // 닫을 때는 연 순서의 역 순으로
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}