package com.tj.ex05_printwriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;

public class Ex01 {
	public static void main(String[] args) {
		OutputStream os = null;// 1byte 기본스트림
		Writer writer = null;// 2byte 기본스트림
		PrintWriter printwriter = null;
		
		try {
//			os = new FileOutputStream("txtFile/outTest.txt"); //기본스트림 열기
//			writer = new FileWriter("txtFile/outTest.txt");
//			printwriter = new PrintWriter(writer); //보조스트림 열기
			printwriter = new PrintWriter("txtFile/outTest.txt");
			System.out.println("안녕하세요\n반갑습니다."); //콘솔창에 뿌리기
			printwriter.println("안녕하세요\r\n반갑습니다.");//파일에 뿌리기
			System.out.printf("%5s %3d %3d %5.1f\n", "홍길동", 100, 100, 100.0);
			printwriter.printf("%5s %3d %3d %5.1f\n", "홍길동", 100, 100, 100.0);
			System.out.printf("%5s %3d %3d %5.1f\n", "마길동", 90, 95, 100.0);
			printwriter.printf("%5s %3d %3d %5.1f\n", "마길동", 90, 95, 100.0);
			System.out.printf("%1$ty년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초", new Date());
			printwriter.printf("%1$ty년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초", new Date());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				printwriter.close();
//				if(os!=null) os.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
