package com.tj.ex12_book;
// �������̽����� 1. ��� 2. �߻�޼ҵ� ��.
public interface ILendable {

	//���� �ʿ� ����
	public byte STATE_BORROWED = 1; // (���) ���� �Ұ��� ����(=���� ��)
	public byte STATE_NORMAL = 0; // (���) ���� ���� ����
	
	public void checkOut(String borrower, String checkOutDate); // (�߻�޼ҵ�) ���� ��
	public void checkIn(); // (�߻�޼ҵ�) �ݳ� ��
	public void printState(); // (�߻�޼ҵ�) ���������� ���� ���� ��� ex) �̰��� �ڹٴ� �ſ�� �� ���� ��
	
}
