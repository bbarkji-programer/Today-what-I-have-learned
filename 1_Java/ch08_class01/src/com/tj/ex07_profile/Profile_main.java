package com.tj.ex07_profile;

public class Profile_main {
	public static void main(String[] args) {
		
		//����
//		Profile man = new Profile("ȫ�浿", 20, 'm');
//		Profile woman = new Profile();
//			woman.setName("ȫ���");
//			woman.setAge(19);
//			woman.setSex('f');
//		
//		man.print();
//		woman.print();

		// �ڹ迭 �Լ� Ȱ���ϴ� ���(1) -> ���� �ڷ����� �ݺ��� �� Ȱ���ϸ� ����
		Profile[] man = { new Profile("ȫ�浿", 20, 'm'),
		                  new Profile("ȫ���", 19, 'f')
		};
		for(Profile m : man) {
			m.print(); // �Ϲݱ���
		}
		for(int idx=0 ; idx<man.length ; idx++) {
			man[idx].print(); // Ȯ�屸��
		}
		
		// �ٹ迭�� Ȱ���ϴ� ���(2)
		Profile[] person = new Profile[2];
		person[0] = new Profile("ȫ�浿", 20, 'm');
		person[1] = new Profile("ȫ���", 19, 'f');
		for(Profile p : person) {
			p.print();
		}
	}
}
