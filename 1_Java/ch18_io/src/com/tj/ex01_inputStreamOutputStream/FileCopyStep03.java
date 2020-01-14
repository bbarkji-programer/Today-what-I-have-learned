package com.tj.ex01_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1) �Է� ��Ʈ�� ����. ��� ��Ʈ�� ����.
// 2) ���� ������ �״�� write �Ѵ�. (���� ������)
// 3) �Է� ��Ʈ���� ��� ��Ʈ���� �ݴ´�.

public class FileCopyStep03 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		File file = new File("txtFile/choi.jpg"); // ���Ͽ� ���� ������ �����´�.
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream("txtFile/choi_copy.jpg");
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()]; // ������ ũ�⸸ŭ ��������. ���� ũ�Ⱑ long ���̴ϱ� int�� �� ��ȯ �ʿ�.
			while(true) {
				cnt++;
				int readByteCount = is.read(bs); 
				if(readByteCount==-1) { 
					break;
				}os.write(bs,0,readByteCount); 
			}
			System.out.println("���� ī�� �Ϸ�. while�� ��� ���Ҵ��� : "+cnt); /// 2�� ���� 1�� ����.
		} catch (FileNotFoundException e) {
			System.out.println("���� ��ã��"+e.getMessage());
		} catch (IOException e) {
			System.out.println("�б� ����"+e.getMessage());
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
