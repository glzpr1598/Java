package chap02.ex09.continueEx;

public class Ex01 {
	// continue문
	// 1부터 10까지 3의 배수가 아닌 수 출력
	public static void main(String[] args) {
		
//		for (int i = 1; i <= 10; i++) {
//			if (i % 3 == 0) {
//				continue;
//			}
//			System.out.println(i);
//		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 3) break;
				System.out.println(i + " " + j);
			}
		}
	}

}
