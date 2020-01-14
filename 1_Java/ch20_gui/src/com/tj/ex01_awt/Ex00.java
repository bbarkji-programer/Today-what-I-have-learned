package com.tj.ex01_awt;

import java.awt.*;

public class Ex00 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("button");
		frame.add(btn); // 창 위에 버튼이 올라간다.
		Button btn2 = new Button("2nd button");
		frame.add(btn2);
		frame.setSize(new Dimension(300,200)); // 창 사이즈 - 가로 300 픽셀, 세로 200 픽셀
//		frame.pack(); //최소한의 사이즈
		frame.setBackground(Color.GREEN);
		frame.setLocation(800, 400); // 창 위치 - 가로 100, 세로 50 띠고
		frame.setVisible(true); // 프레임을 창에 보이게
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false); // 화면에 안보이게 
		frame.dispose(); // 자원해제
		System.exit(0); // 강제종료
	} 
}
