package com.tj.ex08_decimalformat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex01 {
	public static void main(String[] args) {
		double number = 1234567.8389;
		String[] patterns = {"00000000.00000","#.#####", "#,###.##", "0,000.00", "#.##%", "#.###E0"};
		for(String p : patterns) {
			DecimalFormat df = new DecimalFormat(p);
			System.out.println(df.format(number));
		}
	}
}
//		
//		DecimalFormat df = new DecimalFormat("00000000.00000");// 0
//			System.out.println(df.format(number));
//		DecimalFormat df1 = new DecimalFormat("0");// 0
//			System.out.println(df1.format(number));
//		DecimalFormat df2 = new DecimalFormat("#.#####");
//			System.out.println(df2.format(number));
//		DecimalFormat df3 = new DecimalFormat("#,###.##");
//			System.out.println(df3.format(number));
//		DecimalFormat df4 = new DecimalFormat("0,000.00");
//			System.out.println(df4.format(number));
//		DecimalFormat df5 = new DecimalFormat("#.##%");
//			System.out.println(df5.format(number));
//		DecimalFormat df6 = new DecimalFormat("#.###E0");
//			System.out.println(df6.format(number));
		
		
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
