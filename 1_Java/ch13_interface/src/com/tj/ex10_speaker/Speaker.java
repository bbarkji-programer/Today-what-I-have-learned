package com.tj.ex10_speaker;

public class Speaker implements IVolume {

	private final int SPEAKER_MAX_VOLUME = 20;
	private final int SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;
	
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	
	@Override
	public void volumeUp() {
		volumeLevel++;
		if(volumeLevel >= SPEAKER_MAX_VOLUME) {
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("����Ŀ ������ �ְ�ġ�Դϴ�.");
		}else {
          System.out.println("����Ŀ ������ 1��ŭ �÷� ���� ������ "+volumeLevel);
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if(volumeLevel >= SPEAKER_MAX_VOLUME) {
		    volumeLevel = SPEAKER_MAX_VOLUME;
					System.out.println("����Ŀ ������ �ְ�ġ �Դϴ�.");
		}else {
		System.out.println("����Ŀ ������ "+level+"��ŭ �÷� ���� ������ "+volumeLevel);
		}
	}
		

	@Override
	public void volumeDown() {
		volumeLevel--;
		if(volumeLevel <= SPEAKER_MIN_VOLUME) {
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������ ����ġ�Դϴ�.");
		}else {
			System.out.println("����Ŀ ������ 1��ŭ ���� ���� ������ "+volumeLevel);
		}
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if(volumeLevel <= SPEAKER_MIN_VOLUME) {
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������ ����ġ �Դϴ�.");
		}else {
			System.out.println("����Ŀ ������ "+level+"��ŭ ���� ���� ������ "+volumeLevel);
		}
	}

}
