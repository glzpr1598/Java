package chap02.ex02.twoOper;
// 대입 연산자
public class Subs {

	public static void main(String[] args) {
		// (A = A + 10) == (A += 10)
		int result = 0;
		
		result += 10;
		System.out.println(result);
		
		result -= 5;
		System.out.println(result);
		
		result *= 2;
		System.out.println(result);
		
		result /= 2;
		System.out.println(result);
		
		result %= 2;
		System.out.println(result);
		
		// 응용
		// 문자열 더하기
		System.out.println();
		String str = "대입 연산자는 ";
		str += "합한 값을 ";
		str += "누적하는데 ";
		str += "아주 유용하게 사용한다.";
		System.out.println(str);
		
		// 1~5까지의 합
		int sum = 0;
		sum += 1;
		sum += 2;
		sum += 3;
		sum += 4;
		sum += 5;
		System.out.println(sum);

	}

}
