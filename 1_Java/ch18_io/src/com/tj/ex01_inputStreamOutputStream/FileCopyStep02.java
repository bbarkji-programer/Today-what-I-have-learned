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

public class FileCopyStep02 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/choi.jpg");
			os = new FileOutputStream("txtFile/choi_copy.jpg"); // copy�� ���� ����. (������ ���� �����.)
			int cnt = 0;
			byte[] bs = new byte[1024]; // 1K�� ��������
			while(true) {
				cnt++;
				int readByteCount = is.read(bs); // (10K)1024byte �� �а�
				if(readByteCount==-1) { // i�� -1�� �ɶ�����(=������ ����������)
					break;
				}os.write(bs,0,readByteCount); // bs �迭�� 0�ε������� readByteCount ����Ʈ ��ŭ ����.
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
