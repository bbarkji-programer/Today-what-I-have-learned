package com.tj.ex06_boxorrect;

//�ڽ� : ����, ����, ����
//���簢�� : ����, ����, 0
public class Box_or_Rect {
	// �ʿ䵥����
	private int width;
	private int height;
	private int depth;
	private int volume;

	// default ������
	public Box_or_Rect() {
	}

	// Box ������
	public Box_or_Rect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	// ���簢�� ������
	public Box_or_Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void calVolume() {
		if (depth == 0) {
			volume = width * height;
		} else {
			volume = width * height * depth;
		} // if
	}// calVolume
	// getter, setter (�ڵ��ϼ� : alt+shift+s)

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}// class

