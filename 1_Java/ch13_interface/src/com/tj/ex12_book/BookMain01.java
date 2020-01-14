package com.tj.ex12_book;
import java.util.Scanner;
public class BookMain01 {

	public static void main(String[] args) {
		
		BookLib[] books = {new BookLib("890-01", "java", "�ſ��"),
				new BookLib("890-02", "dbms", "����"),
				new BookLib("890-03", "html", "�ڿ��"),
				new BookLib("890-04", "css", "�ֿ��"),
				new BookLib("890-05", "jsp", "�̿��")};
		
		Scanner sc = new Scanner(System.in);
		// �ʿ��� ����
		String bTitle; // �Է��� å ����
		int idx; // �����̳� �ݳ��� ó���� å�� index
		String borrower, checkOutDate; // ��������̶� ������
		int fn; // ��ɹ�ȣ
		
		for(BookLib book : books) {
			book.printState();
		}	
		
		// ������ ���ϴ���, �ݳ��� ���ϴ��� �ݵ�� �� ���� ������� �ϴϱ� Do While��		
		do {
			System.out.print("[1]���� ����, [2]���� �ݳ�, [0]����");
			fn = sc.nextInt();
			switch(fn){
			case 1: // ����ó��
				// 1. å �̸� �Է¹ޱ�
				System.out.print("�����ϰ��� �ϴ� å �̸���: ");
				bTitle = sc.next(); // white-space �� ������ ��Ʈ���� ����.
				// 2. å�� �迭�� �ִ��� �˻�
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) { // ��ü�ϱ� == �ƴϰ� equals(��)
						break; 
					}
				}
				// idx<books.length ��� ã�Ҵ�. idx==books.length�� ���� �� ã�� ��찡 ��.
				if(idx==books.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");
				}else {
					// 3. å ���� Ȯ��
					if(books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("���� ���� ���� �����Դϴ�.");
					}else {
						// 4. ������ �Է�
						System.out.println("������ �̸���: ");
						borrower = sc.next();
						// 5. ������ �Է�
						System.out.println("������(���ó�¥)��: (��:12-06) ");
						checkOutDate = sc.next();
						// 6. ����
						books[idx].checkOut(borrower, checkOutDate);
					
					}
					break;	
				}		
			case 2: // �ݳ�ó��
				// 1. å �̸� �Է¹ޱ�
				System.out.print("�ݳ��ϰ��� �ϴ� å �̸���: ");
				bTitle = sc.next();
				// 2. å(�� �迭�� �ִ���) �˻�
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("�� ������ �� ������ �弭�� �ƴմϴ�.");
				}else {
					//3. �ݳ�
					books[idx].checkIn();

				}
				break;
			case 0 :
				break;
			default:
				System.out.println("��ȿ���� ���� ��ɹ�ȣ�Դϴ�.");
			}		
		}while(fn!=0);
		
		for(BookLib book : books) {
			book.printState();
		}
		
		System.out.println("�ȳ��� ������.");
		sc.close();
	}
}
