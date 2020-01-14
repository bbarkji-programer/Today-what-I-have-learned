package com.tj.ex06_vote;

public class VoteThreadTestMain {
	public static void main(String[] args) {
	Thread target01 = new VoteThread("location01");
	Thread target02 = new VoteThread("location02");
	Thread target03 = new VoteThread("location03");
	target01.start();
	target02.start();
	target03.start();	
	}
}
