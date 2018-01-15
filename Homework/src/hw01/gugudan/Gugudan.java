package hw01.gugudan;

import java.util.Scanner;

// 원하는 단수를 입력 받아 구구단을 만들어 본다.
public class Gugudan {

	public static void main(String[] args) {
		int dan;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단을 입력하세요.");
		dan = sc.nextInt();
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}

	}

}
