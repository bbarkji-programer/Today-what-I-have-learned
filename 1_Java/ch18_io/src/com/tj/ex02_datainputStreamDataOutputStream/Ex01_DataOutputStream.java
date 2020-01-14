package com.tj.ex02_datainputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null; // �⺻ ��Ʈ�� ����
		DataOutputStream dos = null; // ���� ��Ʈ�� ����
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(fos);
			dos.writeUTF("������"); // String��
			dos.writeInt(2); // int��
			dos.writeDouble(95.9); // double��
		} catch (FileNotFoundException e){
			System.out.println("���� ����"+e.getMessage());			
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());			
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();; // ���� ���� �� ���� �Ųٷ�.
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}