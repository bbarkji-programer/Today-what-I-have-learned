package com.tj.ex01_store;

public class Store1 extends HeadQuarterStore{

		private String str = "[���ð� 1ȣ��]";
		
		@Override
		public void budai() {
			System.out.println("�δ�� 5,000��");
		}
		@Override
		public void sundai() {
			System.out.println("���뱹 ���Ⱦ�");
		}

		@Override
		public void kimchi() {
			System.out.println("��ġ� 5,000��");
		}
		@Override
		public void bibib() {
			System.out.println("����� 6,000��");
		}
		@Override
		public void gongibab() {
			System.out.println("����� 1,000��");
		}
		public String getStr() {
			return str;
			}
}
