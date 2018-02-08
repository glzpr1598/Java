package chap07.ex06.multiCatch;

public class OrCatch {

	public static void main(String[] args) {

		String[] strArr = new String[2];

		try {
			strArr[0] = "1234";
			strArr[1] = "ab12";
			strArr[2] = "abcd";

			int num1 = Integer.parseInt(strArr[0]);
			int num2 = Integer.parseInt(strArr[1]);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) { // or 연산을 이용해 여러개를 동시에(jdk 1.7 이상부터)
			System.out.println("ArrayIndexOutOfBoundsException 또는 NumberFormatException 발생!");
		} finally {
			System.out.println("무조건 실행");
		}

	}

}
