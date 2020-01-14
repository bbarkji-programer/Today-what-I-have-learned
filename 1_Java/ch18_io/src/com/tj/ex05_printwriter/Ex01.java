package com.tj.ex05_printwriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;

public class Ex01 {
	public static void main(String[] args) {
		OutputStream os = null;// 1byte �⺻��Ʈ��
		Writer writer = null;// 2byte �⺻��Ʈ��
		PrintWriter printwriter = null;
		
		try {
//			os = new FileOutputStream("txtFile/outTest.txt"); //�⺻��Ʈ�� ����
//			writer = new FileWriter("txtFile/outTest.txt");
//			printwriter = new PrintWriter(writer); //������Ʈ�� ����
			printwriter = new PrintWriter("txtFile/outTest.txt");
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�."); //�ܼ�â�� �Ѹ���
			printwriter.println("�ȳ��ϼ���\r\n�ݰ����ϴ�.");//���Ͽ� �Ѹ���
			System.out.printf("%5s %3d %3d %5.1f\n", "ȫ�浿", 100, 100, 100.0);
			printwriter.printf("%5s %3d %3d %5.1f\n", "ȫ�浿", 100, 100, 100.0);
			System.out.printf("%5s %3d %3d %5.1f\n", "���浿", 90, 95, 100.0);
			printwriter.printf("%5s %3d %3d %5.1f\n", "���浿", 90, 95, 100.0);
			System.out.printf("%1$ty�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��", new Date());
			printwriter.printf("%1$ty�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��", new Date());
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
