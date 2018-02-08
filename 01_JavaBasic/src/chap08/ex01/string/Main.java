package chap08.ex01.string;

public class Main {

	public static void main(String[] args) {
		// 문자열 정의
		// 방법1
		String str1 = "abcd";
		System.out.println(str1);
		
		// 방법2
		String str2 = new String("efgh");
		System.out.println(str2);
		
		// 방법3
		char[] charArr = {'i', 'j', 'k', 'l'};
		String str3 = new String(charArr);
		System.out.println(str3);

	}

}
