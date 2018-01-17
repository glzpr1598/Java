package chap02.ex03.threeOper;
// 삼항 연산자(조건 연산자)
public class Scores {

	public static void main(String[] args) {
		// 조건 연산자
		int score = 85;
		char grade = score > 90 ? 'A' : 'B';
		System.out.println(grade);
		
		// 응용
		// 90보다 크면 A, 80보다 크면 B, 나머지는 C
		grade = score > 80 ? 'B' : 'C';
		grade = score > 90 ? 'A' : grade;
		System.out.println(grade);
		
		// 아래 방법도 가능
		grade = score > 90 ? 'A' : score > 80 ? 'B' : 'C';
		System.out.println(grade);

	}

}
