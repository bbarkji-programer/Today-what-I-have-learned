package com.tj.quiz01;

public interface ILendable {

	public String STATE_BORROWED = "����� ����"; // ���� �Ұ���
	public String STATE_NORMAL = "���� ����"; // ���� ����
	
	public void checkOut(String borrower) throws Exception; // ���� ��
	public void checkIn() throws Exception; // �ݳ� �� 
	
}
