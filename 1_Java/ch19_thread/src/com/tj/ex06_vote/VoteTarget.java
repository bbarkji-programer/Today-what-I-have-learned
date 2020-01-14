package com.tj.ex06_vote;

import java.util.Random;

public class VoteTarget implements Runnable {
	
	private int count; // ��ǥ��
	private Random random; // ���ڴ� �������� ������ �ؾ�¡
	private final int TARGETCNT; // ��ǥ ī��Ʈ(CNT=count) 
	private StringBuilder graph; // String�� ���� �޸𸮰� ����Ǵϱ�. /////// ��������
	
	public VoteTarget() {
		count = 0;
		random = new Random(); 
		TARGETCNT = 100; 
		graph = new StringBuilder(); /////// �ʱ�ȭ�� �����ڿ���
	}
	
	@Override
	public void run() {
		while(true) {
			// count ��ǥ���� random.nextInt(10)��ŭ �ø���
			count += random.nextInt(10); // 0~9������ ������ ���ڰ� ���´�.
			if(count>=TARGETCNT) { // ���࿡ count�� 100�̻��� �ǹ����� ���
				count = TARGETCNT; // ������ 100���� ����
				// count ���� �� �����
				graph.delete(0, graph.toString().length()); // ���� graph �� �� �����(0�� �ε�������, ~ ���� �� ������)
				for(int i=0 ; i<count ; i++) {
					graph.append('��'); // count(��ǥ��)��ŭ ���� �Ѹ���.
				}
				// �����̸�(�������̸�), count (��ǥ��), gragh(��)�� ���
				System.out.println(Thread.currentThread().getName()+"\t"+count+"% ��ǥ "+graph);
				break;
			}else {
				graph.delete(0, graph.toString().length()); // ���� graph �� �� �����
				for(int i=0 ; i<count ; i++) {
					graph.append('��'); // count(��ǥ��)��ŭ ���� �Ѹ���.
				}
				// �����̸�(�������̸�), count (��ǥ��), gragh(��)�� ���
				System.out.println(Thread.currentThread().getName()+"\t"+count+"% ��ǥ "+graph);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}		
		}		
	}
}
