package chap07.ex06.multiCatch;

public class PolyException {

	public static void main(String[] args) {

		String[] strArr = new String[2];

		try {
			strArr[0] = "1234";
			strArr[1] = "ab12";
			strArr[2] = "abcd";

			int num1 = Integer.parseInt(strArr[0]);
			int num2 = Integer.parseInt(strArr[1]);
		} catch (Exception e) { // 다형성 활용
			System.out.println("Exception 발생!");
			System.out.println(e.toString()); // 예외에 대한 정보
			e.printStackTrace(); // 예외에 대한 자세한 정보 출력
		} finally {
			System.out.println("무조건 실행");
		}

	}
	
}
