package chap02.ex04.ifEx;

// 조건문
public class StmtIf {

	public static void main(String[] args) {

		System.out.println("가게에 간다.");
		int money = 500; // 심부름 값
		int charge = 1000; // 두부 값

		// 만약 두부값이 심부름값보다 비싸면... 외상
		if (money < charge) {
			System.out.println("외상으로 주세요!");
		} else { // if 조건이 true가 아닐 경우 무조건 else 실행
			System.out.println("그냥 살게요.");
		}

		// 만약 두부가 없으면... 순두부
		int dubu = 0;
		if (dubu < 1) {
			System.out.println("순두부 주세요!");
		} else {
			System.out.println("두부 주세요!");
		}

		System.out.println("집에 온다.");
	}

}
