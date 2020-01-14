package com.tj.ex03_writerReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt",true);
			String str = "�ȳ��ϼ���, �ڹ�\r\n�ȳ��ϼ���.";
			writer.write(str);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
