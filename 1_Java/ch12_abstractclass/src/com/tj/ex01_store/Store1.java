package com.tj.ex01_store;

public class Store1 extends HeadQuarterStore{

		private String str = "[ÁÖÅÃ°¡ 1È£Á¡]";
		
		@Override
		public void budai() {
			System.out.println("ºÎ´ëÂî°³ 5,000¿ø");
		}
		@Override
		public void sundai() {
			System.out.println("¼ø´ë±¹ ¾ÈÆÈ¾Æ");
		}

		@Override
		public void kimchi() {
			System.out.println("±èÄ¡Âî°³ 5,000¿ø");
		}
		@Override
		public void bibib() {
			System.out.println("ºñºö¹ä 6,000¿ø");
		}
		@Override
		public void gongibab() {
			System.out.println("°ø±â¹ä 1,000¿ø");
		}
		public String getStr() {
			return str;
			}
}
