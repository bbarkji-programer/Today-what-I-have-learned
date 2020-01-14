
public class Ex_args {
	public static void main(String[] args) {
		// args가 뭐하는 아인지..
		System.out.println("args 배열의 길이: "+args.length);
		for(String temp : args) {
			System.out.println("Hello, "+temp);
		}
	}
}
