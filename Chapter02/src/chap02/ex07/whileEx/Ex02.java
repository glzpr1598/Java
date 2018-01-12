package chap02.ex07.whileEx;

import java.util.Scanner;

public class Ex02 {
	// do-while문
	// 채팅 프로그램
	public static void main(String[] args) {

		System.out.println("000님이 입장했습니다.");
		System.out.println("q를 입력하면 종료됩니다.");

		Scanner sc = new Scanner(System.in);
		String str = "";

		do { // 일단 먼저 한 번 실행
			System.out.print("> ");
			str = sc.nextLine();
			System.out.println("당신 > " + str);
		} while (!str.equals(str)); // 반복 조건 검사

		System.out.println("000님이 퇴장했습니다.");

	}

}
