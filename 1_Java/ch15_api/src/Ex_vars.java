
public class Ex_vars {
// �������� �Լ�
	public static void main(String[] args) {
		System.out.println(sum(10,20));
		System.out.println(sum(10,20,30));
		System.out.println(sum(10,20,30,40));
		System.out.println(sum(10,20,30,40,50));
	}
	private static int sum(int...su) { // ���������Լ�
		int total=0;
//		for(int idx=0 ; idx<su.length ; idx++) {
//			total += su[idx];
//		}
		for(int s : su) {
			total += s;
		}
		return total;
	}
}
