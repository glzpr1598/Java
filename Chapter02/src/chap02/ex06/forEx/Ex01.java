package chap02.ex06.forEx;
// for문
public class Ex01 {
	// 물 1잔당 커피 2스푼 넣기. 물 10잔까지
	public static void main(String[] args) {

		// for(초기값; 조건; 증감) { 실행할 문장 }
		for (int cup = 1; cup <= 10; cup++) {
			System.out.println("물을 " + cup + "잔 떠왔습니다.");
			for (int coffee = 1; coffee <= 2; coffee++) {
				System.out.println(cup + "번째 잔에 커피를 " + coffee + "스푼 넣었습니다.");
			}
			System.out.println();
		}

	}

}
