package chap11.ex03.scanner;

import java.util.Scanner;

public class ScanMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		System.out.println(sc.nextLine()); // 문자열 출력
		
		System.out.print("정수 입력 : ");
		System.out.println(sc.nextInt()); // 정수 출력
		
		System.out.print("실수 입력 : ");
		System.out.println(sc.nextDouble()); // 실수 출력
		
	}

}
