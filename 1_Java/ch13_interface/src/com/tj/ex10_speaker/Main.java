package com.tj.ex10_speaker;

public class Main {

	public static void main(String[] args) {
		
		IVolume[] volume = {new Speaker(3), new TV(6)};
		for(IVolume vol : volume) {
			vol.volumeUp(10);
			vol.volumeUp(10);
			vol.volumeUp(11);
			vol.volumeDown(50);
		}
		
		
	}

}
