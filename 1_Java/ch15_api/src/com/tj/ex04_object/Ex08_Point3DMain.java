package com.tj.ex04_object;

public class Ex08_Point3DMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p0 = new Point3D();
		Point3D p1 = new Point3D(1.1, 2.4, 3.0);
		Point3D p2 = (Point3D)p1.clone();
		System.out.println("p0 ��ǥ����?"+p0);
		System.out.println("p1 ��ǥ����?"+p1);
		System.out.println("p2 ��ǥ����?"+p2);
		System.out.println("p1�� p2�� ������ ����� �Ƴ�?");
		if(p1==p2) {
			System.out.println("�ƴ�, ������ �ƴ϶� ���� ��ü��.");
		}else {
			System.out.println("��, ������ ����� �Ƴ�~");
		}
		System.out.println("p1�� p2�� ���� ��ǥ�ΰ�?");
		if(p1.equals(p2)) {
			System.out.println("��, ���� ��ǥ��.");
		}else {
			System.out.println("�ƴ�, �ٸ� ��ǥ��.");
		}
	}
}
