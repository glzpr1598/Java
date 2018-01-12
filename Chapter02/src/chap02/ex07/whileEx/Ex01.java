package chap02.ex07.whileEx;

public class Ex01 {
	// 1에서 10까지 반복
	public static void main(String[] args) {
		// while(조건) { }

		// 방법 1
		int i = 1;
		while (i <= 10) {
			System.out.println("반복 횟수 : " + i);
			i++;
		}

		// 방법 2
		while (true) {
			System.out.println("반복 횟수 : " + i);
			i++;
			if (i > 10) {
				break;
			}
		}

		// 방법 3
		boolean flag = true;
		while (flag) {
			System.out.println("반복 횟수 : " + i);
			i++;
			if (i > 10) {
				flag = false;
			}
		}

	}

}
