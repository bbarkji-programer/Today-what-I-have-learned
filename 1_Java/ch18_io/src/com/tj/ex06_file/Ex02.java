package com.tj.ex06_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex02 {
	public static void main(String[] args) {
		File file = new File("."); 
		if(file.exists()) {
			System.out.println("존재하는 파일");
		}else {
			System.out.println("존재하지 않는 파일");
		}
		try {
			System.out.println("절대경로 : "+file.getAbsolutePath());
			System.out.println("표준경로 : "+file.getCanonicalPath());
			Date thatTime = new Date(file.lastModified()); // 파일 최종 수정 시간
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd(E) hh:mm:ss");
			System.out.println("최종 수정 시간 : "+sdf.format(thatTime));
			System.out.println("파일 크기 : "+file.length());
			System.out.println("읽기 속성 : "+file.canRead());
			System.out.println("쓰기 속성 : "+file.canWrite());
			System.out.println("숨김 속성 : "+file.isHidden());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
