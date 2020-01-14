package com.tj.ex02_datainputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null; // 기본 스트림 변수
		DataOutputStream dos = null; // 보조 스트림 변수
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(fos);
			dos.writeUTF("최정훈"); // String값
			dos.writeInt(2); // int값
			dos.writeDouble(95.9); // double갑
		} catch (FileNotFoundException e){
			System.out.println("폴더 없음"+e.getMessage());			
		} catch (IOException e) {
			System.out.println("쓰기 예외"+e.getMessage());			
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();; // 닫을 때는 연 순서 거꾸로.
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}