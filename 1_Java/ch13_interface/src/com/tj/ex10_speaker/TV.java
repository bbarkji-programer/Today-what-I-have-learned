package com.tj.ex10_speaker;

public class TV implements IVolume {
	
	private final int TV_MAX_VOLUME = 30; // final 변수를 위에 써준다.
	private final int TV_MIN_VOLUME = 0;
	private int volumeLevel;
	
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}	

	@Override
	public void volumeUp() {
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨을 1만큼 올려 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최고치여서 올리지 못했습니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		if((volumeLevel+level) <= TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV 볼륨을 "+level+"만큼 올려 현재 레벨이 "+volumeLevel);
		}else { // 현재 볼륨이 25, level이 10 -> 5만 올린다.
			int tempLevel = TV_MAX_VOLUME - volumeLevel; // -> 5
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 올리지 못하고, "+tempLevel+"만큼 올려 최고치");
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV 볼륨을 1만큼 내려 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최저치여서 내리지 못했습니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		if((volumeLevel-level)>=TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV 볼륨을 "+level+"만큼 내려 현재 레벨이 "+volumeLevel);
		}else { // 현재 볼륨이 5, level이 10
			int tempLevel = volumeLevel;
			System.out.println("TV 볼륨을 "+level+"만큼 내리지 못하고, "+tempLevel+"만큼 내려 최저치");
		}
		// TODO Auto-generated method stub

	}

}
