package com.tj.ex06_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex02 {
	public static void main(String[] args) {
		File file = new File("."); 
		if(file.exists()) {
			System.out.println("�����ϴ� ����");
		}else {
			System.out.println("�������� �ʴ� ����");
		}
		try {
			System.out.println("������ : "+file.getAbsolutePath());
			System.out.println("ǥ�ذ�� : "+file.getCanonicalPath());
			Date thatTime = new Date(file.lastModified()); // ���� ���� ���� �ð�
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd(E) hh:mm:ss");
			System.out.println("���� ���� �ð� : "+sdf.format(thatTime));
			System.out.println("���� ũ�� : "+file.length());
			System.out.println("�б� �Ӽ� : "+file.canRead());
			System.out.println("���� �Ӽ� : "+file.canWrite());
			System.out.println("���� �Ӽ� : "+file.isHidden());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
