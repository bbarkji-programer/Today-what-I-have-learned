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
			fis = new FileInputStream("txtFile/dataFile.dat"); // �⺻ ��Ʈ�� ���� ����.
			dis = new DataInputStream(fis); // ������Ʈ���� �⺻ ��Ʈ�� ���� ����.
			String name = dis.readUTF();
			int grade = dis.readInt();
			double score = dis.readDouble(); // �Է��� ���� �Է��� ������� ����.
			System.out.println("�Է� ���� ���� : "+name+"\t"+grade+"\t"+score);
		} catch (FileNotFoundException e) {
			System.out.println("���� ����"+e.getMessage());	
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close(); // ���� ���� �� ������ �� ������
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}