package com.tj.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_simpleDateFormat {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy�� MM�� dd�� hh�� mm��");
		String todayStr = sdf.format(date); // ����Ʈ�� �����̱� ������ �� �ᵵ �ȴ�.
		System.out.println(todayStr);
	}
}
