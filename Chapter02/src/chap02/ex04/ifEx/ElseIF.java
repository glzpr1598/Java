package chap02.ex04.ifEx;

import java.util.Scanner;

public class ElseIF {

	public static void main(String[] args) {

		// 콜라, 커피, 보리차, 식혜, 사이다
		// 선택시 음료가 나오도록
		System.out.println("음료를 선택하세요!");
		Scanner scan = new Scanner(System.in);
		String item = scan.nextLine();

		if (item.equals("콜라")) {
			System.out.println("선택한 음료 : 콜라");
		} else if (item.equals("커피")) {
			System.out.println("선택한 음료 : 커피");
		} else if (item.equals("보리차")) {
			System.out.println("선택한 음료 : 보리차");
		} else if (item.equals("식혜")) {
			System.out.println("선택한 음료 : 식혜");
		} else if (item.equals("사이다")) {
			System.out.println("선택한 음료 : 사이다");
		}

		// System.out.println("선택한 음료 : " + item);

	}

}
