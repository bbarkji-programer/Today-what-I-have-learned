package com.tj.ex04_object;
// �� ��' �� A(1), 2~10, 11,12,13
// ���� ����, ���� -> �ּ� �� ���� ���� �ʿ�
public class Card {
	private char kind; // �� �� �� ��
	private int num; // A(1), 2~10, J(11),Q(12),K(13)
    
	// Card c1 = new Card('��', 2);
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "�����Ͻ� ī��� �� "+kind+" "+num;
	}
	@Override
	public boolean equals(Object obj) {
		//c1.equals(c2) c1->this, c2->obj
		if(obj!=null && obj instanceof Card ) { // c2�� null�� �ƴϰ�, Card�� ��������
			//kind ����
			boolean kindChk = this.kind == ((Card)obj).kind; // obj Ÿ�������� Card�� �����̴ϱ� ����� ����ȯ ����
			//num ����
			boolean numChk = this.num == ((Card)obj).num; // Card Ÿ���̴ϱ� ����� ����ȯ ���� // ��ü ������ Ÿ���̸� == �ƴϰ� .equals() ����ؾ�
			return kindChk && numChk;
			
		}else {
		return false;
		}
	}
}
