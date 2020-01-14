package com.tj.ex10_speaker;

public class Practice_Speaker implements IVolume {

	//정보(여기서만 쓸)
	private final int SPEAKER_MAX_VOLUME = 20; // 이 스피커의 최고 볼륨은 20으로. 상수.
	private final int SPEAKER_MIN_VOLUME= 0; // 이 스피커의 최저 볼륨은 0으로. 상수.
	private int volumeLevel; // 임시 변수 같은 건가?
	
	//생성자(메인함수에서 써먹을 것)
	public Practice_Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	
	//메소드
	@Override
	public void volumeUp() { // 메인 함수에서 볼륨값을 따로 안넣고 쓰는 경우
		volumeLevel++; // 볼륨 레벨을 1만큼 올렸는데
		if(volumeLevel >= SPEAKER_MAX_VOLUME) { // 만약에 볼륨이 최고치보다 커지면,
			volumeLevel = SPEAKER_MAX_VOLUME; // 볼륨을 최고치에 걍 맞추고,
				System.out.println("스피커 볼륨이 최고치 입니다."); // 를 출력.
		}else { // 만약에 최고치보다 커지지 않으면,
				System.out.println("스피커 볼륨을 1만큼 올려 현재 레벨이 "+volumeLevel); // 를 출력.
		}
	}

	@Override
	public void volumeUp(int level) { // 메인 함수에서 볼륨값을 따로 넣은 경우
		volumeLevel += level; //볼륨을 입력한 숫자 만큼 높이고,
		if(volumeLevel >= SPEAKER_MAX_VOLUME) { // 근데 그렇게 높인 볼륨이 최고 볼륨보다 커지면,
			volumeLevel = SPEAKER_MAX_VOLUME; // 볼륨을 최고치에 걍 맞추고,
				System.out.println("스피커 볼륨이 최고치 입니다."); //를 출력
		}else { // 높인 볼륨이 최고치보다 낮으면,
			System.out.println("스피커 볼륨을 "+level+"만큼 올려 현재 레벨이 "+volumeLevel);
		}
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeDown(int level) {
		// TODO Auto-generated method stub
		
	}
}
