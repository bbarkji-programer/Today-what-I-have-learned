package com.tj.ex10_speaker;

public class Practice_Speaker implements IVolume {

	//����(���⼭�� ��)
	private final int SPEAKER_MAX_VOLUME = 20; // �� ����Ŀ�� �ְ� ������ 20����. ���.
	private final int SPEAKER_MIN_VOLUME= 0; // �� ����Ŀ�� ���� ������ 0����. ���.
	private int volumeLevel; // �ӽ� ���� ���� �ǰ�?
	
	//������(�����Լ����� ����� ��)
	public Practice_Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	
	//�޼ҵ�
	@Override
	public void volumeUp() { // ���� �Լ����� �������� ���� �ȳְ� ���� ���
		volumeLevel++; // ���� ������ 1��ŭ �÷ȴµ�
		if(volumeLevel >= SPEAKER_MAX_VOLUME) { // ���࿡ ������ �ְ�ġ���� Ŀ����,
			volumeLevel = SPEAKER_MAX_VOLUME; // ������ �ְ�ġ�� �� ���߰�,
				System.out.println("����Ŀ ������ �ְ�ġ �Դϴ�."); // �� ���.
		}else { // ���࿡ �ְ�ġ���� Ŀ���� ������,
				System.out.println("����Ŀ ������ 1��ŭ �÷� ���� ������ "+volumeLevel); // �� ���.
		}
	}

	@Override
	public void volumeUp(int level) { // ���� �Լ����� �������� ���� ���� ���
		volumeLevel += level; //������ �Է��� ���� ��ŭ ���̰�,
		if(volumeLevel >= SPEAKER_MAX_VOLUME) { // �ٵ� �׷��� ���� ������ �ְ� �������� Ŀ����,
			volumeLevel = SPEAKER_MAX_VOLUME; // ������ �ְ�ġ�� �� ���߰�,
				System.out.println("����Ŀ ������ �ְ�ġ �Դϴ�."); //�� ���
		}else { // ���� ������ �ְ�ġ���� ������,
			System.out.println("����Ŀ ������ "+level+"��ŭ �÷� ���� ������ "+volumeLevel);
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
