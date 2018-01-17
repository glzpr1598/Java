package chap02.ex02.twoOper;
// 이항 연산자
public class Two {

	public static void main(String[] args) {
		// 피연산자1 연산자 피연산자2
		// 1 + 2
		// % : 나머지를 구할 때
		// 짝수나 홀수 또는 배수를 구할 때 주로 사용
		System.out.println(5%2);		// 1
		
		// 문자열 더하기
		// 숫자 + 숫자
		System.out.println(1+3);	// 4
		// 문자 + 숫자
		System.out.println("JDK " + 8 + 0.65); 	// JDK 80.65
		// 숫자 + 문자
		System.out.println(8+0.65+" JDK"); 	// 8.65 JDK
		// 문자 + 문자
		System.out.println("A"+" "+"B");	// A B

	}

}
