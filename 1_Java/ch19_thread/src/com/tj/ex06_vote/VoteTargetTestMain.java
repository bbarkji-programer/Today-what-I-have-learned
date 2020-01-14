package com.tj.ex06_vote;

public class VoteTargetTestMain {
	public static void main(String[] args) {
		Runnable target01 = new VoteTarget();
		Runnable target02 = new VoteTarget();
		Runnable target03 = new VoteTarget();
		Thread location01 = new Thread(target01, "location01");
		Thread location02 = new Thread(target02, "location02");
		Thread location03 = new Thread(target03, "location03"); ////// ¾²·¹µå 3°³, °´Ã¼ 3°³ ¸¸µë
		
		location01.start();
		location02.start();
		location03.start();
		
		
	}
}
