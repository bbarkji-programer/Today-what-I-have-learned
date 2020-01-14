package ch00_practice;

public class Gui_customer {
	private String phone;
	private String name;
	private int point;
	
	public Gui_customer() {
	}
	public Gui_customer(String phone, String name) {
		this.phone = phone;
		this.name = name;
		point = 1000;
	}
	@Override
	public String toString() {
		return "[폰번호] "+phone+" [이름] "+name+" [포인트] "+point+"\r\n";
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}
