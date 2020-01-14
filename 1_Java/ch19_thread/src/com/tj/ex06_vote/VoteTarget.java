package com.tj.ex06_vote;

import java.util.Random;

public class VoteTarget implements Runnable {
	
	private int count; // 개표율
	private Random random; // 숫자는 랜덤으로 나오게 해야징
	private final int TARGETCNT; // 목표 카운트(CNT=count) 
	private StringBuilder graph; // String을 쓰면 메모리가 낭비되니까. /////// 변수선언
	
	public VoteTarget() {
		count = 0;
		random = new Random(); 
		TARGETCNT = 100; 
		graph = new StringBuilder(); /////// 초기화는 생성자에서
	}
	
	@Override
	public void run() {
		while(true) {
			// count 개표율을 random.nextInt(10)만큼 올리기
			count += random.nextInt(10); // 0~9까지의 랜덤한 숫자가 나온다.
			if(count>=TARGETCNT) { // 만약에 count가 100이상이 되버리는 경우
				count = TARGETCNT; // 무조건 100으로 맞춤
				// count 마다 별 만들기
				graph.delete(0, graph.toString().length()); // 기존 graph 별 다 지우기(0번 인덱스부터, ~ 개수 다 지워라)
				for(int i=0 ; i<count ; i++) {
					graph.append('★'); // count(개표율)만큼 별을 뿌린다.
				}
				// 지역이름(쓰레드이름), count (개표율), gragh(★)를 출력
				System.out.println(Thread.currentThread().getName()+"\t"+count+"% 개표 "+graph);
				break;
			}else {
				graph.delete(0, graph.toString().length()); // 기존 graph 별 다 지우기
				for(int i=0 ; i<count ; i++) {
					graph.append('★'); // count(개표율)만큼 별을 뿌린다.
				}
				// 지역이름(쓰레드이름), count (개표율), gragh(★)를 출력
				System.out.println(Thread.currentThread().getName()+"\t"+count+"% 개표 "+graph);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}		
		}		
	}
}
