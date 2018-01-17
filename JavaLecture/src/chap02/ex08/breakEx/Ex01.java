package chap02.ex08.breakEx;

public class Ex01 {
	// break문
	public static void main(String[] args) {
		// 반복문에서 3이 되었을 때 break문을 사용하여 빠져나가도록
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			if (i == 3) {
				break;
			}
		}

	}

}
