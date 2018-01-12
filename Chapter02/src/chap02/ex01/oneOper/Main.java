package chap02.ex01.oneOper;
// 단항 연산자
public class Main {

	public static void main(String[] args) {
	
		// 증감연산
		int x = 10;
		int y = 10;
		x++;
		++y;
		System.out.println(x);
		System.out.println(y);

		int result;
		x = 1;
		y = 1;
		
		result = (x++) + 10;
		System.out.println(result);	// 11
		
		result = (++y) + 10;
		System.out.println(result);	// 12
		
		// 논리부정 연산
		boolean flag = true;
		flag = !flag;
		System.out.println(flag);	// false
		flag = !flag;
		System.out.println(flag);	// true
	}

}