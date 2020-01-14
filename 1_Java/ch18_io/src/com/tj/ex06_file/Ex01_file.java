package com.tj.ex06_file;

import java.io.File;

public class Ex01_file {
	public static void main(String[] args) {
		File file = new File("."); // ch18_io ������Ʈ ����
		String[] fileStr = file.list();
		for(String fileS : fileStr) {
			System.out.println(fileS);
		}
		System.out.println("������Ʈ ������ ����");
		File[] files = file.listFiles();
		for(File f : files) {
			if(f.getName().length()>=8) {
				System.out.print(f.getName());				
			}else {
				System.out.print(f.getName()+"\t");
			}
			System.out.print("\t"+f.length()+"\t");
			System.out.println(f.isDirectory()? "���丮" : "����");
		}
	}
}
