package com.tj.ex07_profile;

public class Profile {
	//�ʿ䵥����
		private String name;
		private int age;
		private char sex;
		
		//default ������(=�Ű� ���� ���� ������)
		public Profile() {		
		}

		//3���� ���� ��� ������ ������
		public Profile(String name, int age, char sex) {
			this.name = name;
			this.age = age;
			this.sex = sex;			
		}
		
		//��ɸ޼ҵ�(����ض�)
		public void print() { // ����Ʈ �ϰ� ������ �Ŷ� ���ϰ� �ʿ�X -> void
			System.out.println("�̸� = "+name+", ���� = "+age+", ���� = "+sex);
		}
		
		//setter, getter
		//name
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		//age
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		//sex
		public char getSex() {
			return sex;
		}
		public void setSex(char sex) {
			this.sex = sex;
		}		
}
