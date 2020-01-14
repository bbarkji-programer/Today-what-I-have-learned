package com.tj.ex02_date;

import java.util.Calendar;

import com.tj.ex01_string.Friend;
// 오늘 생일인 사람 뿌리기. 없으면 없다고 하기.
public class Ex06 {
	
	public static void main(String[] args) {
		
	//이런 데이터가 있다고 치고,
	Friend[] friends = {new Friend("홍길동", "010-9999-9999", "12-16"),
						new Friend("홍길동", "010-9999-9999", "12-11"),
						new Friend("홍길동", "010-9999-9999", "01-08")};
	
	// 시스템에서 월일가져오기
	Calendar today = Calendar.getInstance(); // 지금시점 가져옴
	int month = today.get(Calendar.MONTH)+1;
	int day = today.get(Calendar.DAY_OF_MONTH);
	
	String monthStr = (month<10) ? "0"+month : ""+month;
	String dayStr = (day<10) ? "0"+day : ""+day;
	String todayStr = monthStr + "-" +dayStr;
	
	System.out.println("오늘은 "+todayStr);
	boolean searchOk = false;
	
	// 생일이 같은 경우가 있는지 확인
	for(Friend friend : friends) { // friend : 임시변수
		if(friend.getBirth().equals(todayStr)) {
			System.out.println("오늘 생일인 친구는\n"+friend.infoString());
			searchOk = true;
		}
	}
	if(!searchOk) {
		System.out.println("오늘 생일인 친구는 없습니다.");
	}
	
	}

}