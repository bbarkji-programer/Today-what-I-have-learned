package com.tj.ex04_object;
// ♥ ◆' ♠ A(1), 2~10, 11,12,13
// 문양 종류, 숫자 -> 최소 두 가지 변수 필요
public class Card {
	private char kind; // ♥ ◆ ♣ ♠
	private int num; // A(1), 2~10, J(11),Q(12),K(13)
    
	// Card c1 = new Card('♥', 2);
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "선택하신 카드는 ☞ "+kind+" "+num;
	}
	@Override
	public boolean equals(Object obj) {
		//c1.equals(c2) c1->this, c2->obj
		if(obj!=null && obj instanceof Card ) { // c2가 null이 아니고, Card형 변수여야
			//kind 같냐
			boolean kindChk = this.kind == ((Card)obj).kind; // obj 타입이지만 Card형 변수이니까 명시적 형변환 가능
			//num 같냐
			boolean numChk = this.num == ((Card)obj).num; // Card 타입이니까 명시적 형변환 가능 // 객체 데이터 타입이면 == 아니고 .equals() 사용해야
			return kindChk && numChk;
			
		}else {
		return false;
		}
	}
}
