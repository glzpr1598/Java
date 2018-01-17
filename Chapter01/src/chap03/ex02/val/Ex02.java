package chap03.ex02.val;

public class Ex02 {

	public static void main(String[] args) {
		// 0~9번까지 10, 20, ..., 100의 값을 넣는다.
		// 1, 3, 5번 방의 값을 출력한다.
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1) * 10;
		}
		
		System.out.println(arr[1]);
		System.out.println(arr[3]);
		System.out.println(arr[5]);
	}

}
