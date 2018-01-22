package chap07.ex05.tryCatch;

public class Main {

	public static void main(String[] args) {

		int[] arr = new int[3];
		
		try { // 예외 발생 가능성이 있는 코드
			arr[0] = 0;
			arr[3] = 3; // 예외가 발생하면 아래 코드는 실행되지 않음.
			arr[2] = 2; // 실행 x
		} catch (ArrayIndexOutOfBoundsException e) { // Arr 예외 발생 시 실행할 코드
			System.out.println("Exception 발생");
			System.out.println(e.toString()); // 예외 발생 내용 출력
		} finally { // 예외 여부에 상관없이 무조건 실행할 코드
			System.out.println("무조건 실행");
		}
		
		System.out.println(arr[2]); // 2가 출력되지 않고 0이 출력됨

	}

}
