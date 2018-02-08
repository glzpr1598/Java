package chap02.ex05.switchEx;
// switch문
import java.util.Scanner;

public class Ex01 {
	
	public static void main(String[] args) {
		// 콜라, 커피, 보리차, 식혜, 사이다
		// 선택시 음료가 나오도록
		System.out.println("음료를 선택하세요!");
		Scanner scan = new Scanner(System.in);
		String item = scan.nextLine();
		System.out.println("선택한 음료 : " + item);

//		if (item.equals("콜라")) {
//			System.out.println("선택한 음료 : 콜라");
//		}
//		else if (item.equals("커피")) {
//			System.out.println("선택한 음료 : 커피");
//		}
//		else if (item.equals("보리차")) {
//			System.out.println("선택한 음료 : 보리차");
//		}
//		else if (item.equals("식혜")) {
//			System.out.println("선택한 음료 : 식혜");
//		}
//		else if (item.equals("사이다")) {
//			System.out.println("선택한 음료 : 사이다");
//		}
		
		// jdk 1.6 이하에서는 case에 숫자만 가능!!
		switch(item) {
			case "콜라" :
				System.out.println(item + "가 나왔습니다.");
				break;
			case "사이다" :
				System.out.println(item + "가 나왔습니다.");
				break;
			case "커피" :
				System.out.println(item + "가 나왔습니다.");
				break;
			case "보리차" :
				System.out.println(item + "가 나왔습니다.");
				break;
			case "식혜" :
				System.out.println(item + "가 나왔습니다.");
				break;
			default :
				System.out.println("해당하는 음료가 없습니다.");
		}

	}

}
