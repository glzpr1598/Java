package chap07.ex04.exception;

public class ClassCastException {

	public static void main(String[] args) {

		Object obj = 1234; // Integer -> Object

		int intVal = (int) obj;
		String str;
		str = (String) obj; // ClassCastException

		// instanceof 활용
		if (obj instanceof String) {
			str = (String) obj;
		} else {
			System.out.println("원형이 문자열이 아닙니다.");
		}

	}

}
