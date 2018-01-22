package chap07.ex04.exception;

public class NullPointerException {
	
	public static void main(String[] args) {
		
		String str = null;

		if (str.equals("Test")) { // NullPointerException
			System.out.println("동일한 문자");
		} else {
			System.out.println("다른 문자");
		}
		
	}

}
