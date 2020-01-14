package com.tj.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1) �Է� ��Ʈ�� ����. ��� ��Ʈ�� ����.
// 2) ���� ������ �״�� write �Ѵ�. (���� ������)
// 3) �Է� ��Ʈ���� ��� ��Ʈ���� �ݴ´�.

public class FileCopyStep01 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/choi.jpg");
			os = new FileOutputStream("txtFile/choi_copy.jpg"); // copy�� ���� ����. (������ ���� �����.)
			int cnt = 0;
			while(true) {
				cnt++;
				int i = is.read(); // �а�
				if(i==-1) { // i�� -1�� �ɶ�����(=������ ����������)
					break;
				}os.write(i); // ����.
			}
			System.out.println("���� ī�� �Ϸ�. while�� ��� ���Ҵ��� : "+cnt);
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
