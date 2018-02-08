package chap02.ex04.ifEx;

import java.util.Scanner;

public class Vending {

	public static void main(String[] args) {
		// 콜라:1000, 사이다:1000, 커피:2000, 보리차:1000, 식혜:1500
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("돈을 넣으세요.");
		int money = sc1.nextInt();
		
		System.out.println("음료를 입력하세요.");
		String item = sc2.nextLine();
		
		System.out.println("넣은 금액 : " + money + ", 선택한 음료 : " + item);
		
		if(item.equals("콜라") && money >= 1000) {
			System.out.println("콜라가 나왔습니다.");
			money -= 1000;
			System.out.println("잔돈은 " + money + "원입니다.");
		}
		else if(item.equals("콜라") && money < 1000) {
			System.out.println("금액이 부족합니다.");
		}
		else if(item.equals("사이다") && money >= 1000) {
			System.out.println("사이다가 나왔습니다.");
			money -= 1000;
			System.out.println("잔돈은 " + money + "원입니다.");
		}
		else if(item.equals("사이다") && money < 1000) {
			System.out.println("금액이 부족합니다.");
		}
		else if(item.equals("커피") && money >= 2000) {
			System.out.println("커피가 나왔습니다.");
			money -= 2000;
			System.out.println("잔돈은 " + money + "원입니다.");
		}
		else if(item.equals("커피") && money < 2000) {
			System.out.println("금액이 부족합니다.");
		}
		else if(item.equals("보리차") && money >= 1000) {
			System.out.println("보리차가 나왔습니다.");
			money -= 1000;
			System.out.println("잔돈은 " + money + "원입니다.");
		}
		else if(item.equals("보리차") && money < 1000) {
			System.out.println("금액이 부족합니다.");
		}
		else if(item.equals("식헤") && money >= 1500) {
			System.out.println("식혜가 나왔습니다.");
			money -= 1500;
			System.out.println("잔돈은 " + money + "원입니다.");
		}
		else if(item.equals("식혜") && money < 1500) {
			System.out.println("금액이 부족합니다.");
		}
		else {
			System.out.println("없는 음료입니다.");
		}

	}

}
