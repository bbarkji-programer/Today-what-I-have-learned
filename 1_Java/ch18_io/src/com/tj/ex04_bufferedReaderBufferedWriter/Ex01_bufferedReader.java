package com.tj.ex04_bufferedReaderBufferedWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// 여러줄을 한 줄씩 읽어오게 할때
public class Ex01_bufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			br = new BufferedReader(reader);
			while(true) {
				String linedata = br.readLine();
				if(linedata==null) break;
				System.out.println(linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(br!=null) br.close();
					if(reader!=null) reader.close();					
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
