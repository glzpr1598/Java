package hw02.baseball;

import java.util.Scanner;

// 1. Strike가 3개면 Out이 된다.
// 2. Ball이 4개면 Strike와 Ball이 초기화된다.
// 3. Out이 3개면 게임이 끝난다.
public class Baseball {

	public static void main(String[] args) {
		int s = 0, b = 0, o = 0;
		String ball;
		Scanner sc = new Scanner(System.in);

		while (true) {
			// 입력
			System.out.println("공을 던지세요.");
			System.out.print("> ");
			ball = sc.nextLine();

			// 입력받은 공에 따라 s, b 카운트
			switch (ball) {
				case "S":
				case "s":
					s++;
					break;
				case "B":
				case "b":
					b++;
					break;
				default:
					System.out.println("S 또는 B를 입력하세요.");
					break;
			}

			// 3 Strike면 S, B 초기화하고 아웃 카운트
			if (s == 3) {
				s = 0;
				b = 0;
				o++;
				System.out.println("Strike out!");
				
			}

			// 4 Ball이면 S, B 초기화
			if (b == 4) {
				s = 0;
				b = 0;
				System.out.println("볼 넷!");
			}

			// 상태 출력
			System.out.println("S:" + s + ", B:" + b + ", O:" + o);
			System.out.println();

			// 3 Out이면 게임 종료
			if (o == 3) {
				System.out.println("게임을 종료합니다.");
				break;
			}

		}

	}

}
