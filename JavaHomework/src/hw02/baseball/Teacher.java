package hw02.baseball;

import java.util.Scanner;

public class Teacher {

	public static void main(String[] args) {
		/*
		 * 1. 입력 받기(s, b, S, B) 2. s를 입력하면 s++ 3. b를 입력하면 b++ 4. s가 3개면 o++, s=0, b=0 5.
		 * b가 4개면 s=0, b=0 6. o이 3개면 게임 끝
		 */
		int s = 0;
		int b = 0;
		int o = 0;

		while (o < 3) { // 차이점 : 아웃 카운트를 while 조건에 넣음.
			System.out.println("던질 공을 선택하세요.(S|B)");
			Scanner sc = new Scanner(System.in);
			String ball = sc.nextLine();
			System.out.println("당신이 던진 공 : " + ball);

			switch (ball) {
			case "S":
			case "s":
				s++;
				if (s >= 3) { // 차이점 : 3S, 4B 조건을 switch문 안에 넣음.
					s = 0;
					b = 0;
					o++;
					System.out.println("Strike out!");
				}
				break;
			case "B":
			case "b":
				b++;
				if (b >= 4) {
					s = 0;
					b = 0;
					System.out.println("볼 넷!");
				}
				break;
			default:
				System.out.println("S 혹은 B를 입력하세요.");
			}

			System.out.println(s + "S " + b + "B " + o + "O");
		}

		System.out.println();
		System.out.println("GAME OVER.");
		
	}

}
