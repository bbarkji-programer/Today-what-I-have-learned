package com.tj.ex10_speaker;

public class TV implements IVolume {
	
	private final int TV_MAX_VOLUME = 30; // final ������ ���� ���ش�.
	private final int TV_MIN_VOLUME = 0;
	private int volumeLevel;
	
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}	

	@Override
	public void volumeUp() {
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV ������ 1��ŭ �÷� "+volumeLevel);
		}else {
			System.out.println("TV ������ �ְ�ġ���� �ø��� ���߽��ϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if((volumeLevel+level) <= TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV ������ "+level+"��ŭ �÷� ���� ������ "+volumeLevel);
		}else { // ���� ������ 25, level�� 10 -> 5�� �ø���.
			int tempLevel = TV_MAX_VOLUME - volumeLevel; // -> 5
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ "+level+"��ŭ �ø��� ���ϰ�, "+tempLevel+"��ŭ �÷� �ְ�ġ");
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV ������ 1��ŭ ���� "+volumeLevel);
		}else {
			System.out.println("TV ������ ����ġ���� ������ ���߽��ϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if((volumeLevel-level)>=TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV ������ "+level+"��ŭ ���� ���� ������ "+volumeLevel);
		}else { // ���� ������ 5, level�� 10
			int tempLevel = volumeLevel;
			System.out.println("TV ������ "+level+"��ŭ ������ ���ϰ�, "+tempLevel+"��ŭ ���� ����ġ");
		}
		// TODO Auto-generated method stub

	}

}
