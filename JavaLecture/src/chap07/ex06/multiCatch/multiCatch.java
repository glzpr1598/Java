package chap07.ex06.multiCatch;

// catch를 여러개
public class multiCatch {

	public static void main(String[] args) {
		
		String[] strArr = new String[2];
		
		try {
			strArr[0] = "1234";
			strArr[1] = "ab12";
			strArr[2] = "abcd";
			
			int num1 = Integer.parseInt(strArr[0]);
			int num2 = Integer.parseInt(strArr[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 발생!");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException 발생!");
		} finally {
			System.out.println("무조건 실행");
		}

	}

}
