package com.tj.op;
// �������� (AND, OR)
public class Op_ex04 {
	public static void main(String[] args) {
	System.out.println("* * *�� ������* * *");
	//(AND, OR => &&, ||)
	
		int i=1, j=10, h=10;
		System.out.println("&&(AND) (i>j) && (++j>h) : "+((i>j) && (++j>h)));
		//                                                  F   &&  T   && ���꿡�� ���� F�� ������ �ڿ� ��� ���� -> j++ ����
		System.out.println(j);
		
		System.out.println("||(AND) (i>j) || (++j>h) : "+((i<j) || (++j>h)));
		//                                                  T   ||  T   || ���꿡���� ���� F�� ���͵� �ڿ� ��� �� / ���� T �̸� �ڿ� ���� ����. -> j++ ����
		System.out.println(j);
		
		
}
}
 