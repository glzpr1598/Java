package chap07.ex04.exception;

public class NumberFormatException {
	
	public static void main(String[] args) {
		
		String str;
		int num;
		
		str = "1234";
		num = Integer.parseInt(str);
		System.out.println(num);
		
		str = "a123";
		num = Integer.parseInt(str); // NumberFormatException
		System.out.println(num);
		
	}

}
