package chap08.ex02.stringUtil;

public class StringArrUtil {
	
	public static void main(String[] args) {
		
		String str = "abcdef";
		
		// 문자열 = char 배열
		
		// 문자열 길이
		System.out.println(str.length()); // 길이 반환
		
		// 특정 인덱스 문자 가져오기
		System.out.println(str.charAt(2)); // char 반환
		
		// 문자열 잘라내기(뽑아내기)
		System.out.println(str.substring(1, 3)); // 1번째부터 보여주고, 3번째부터 잘라냄 -> 1~2번째까지 뽑아냄 -> bc 출력
		
		// String -> char 배열
		char[] charArr = str.toCharArray();
		System.out.println(charArr);
		
		// char 배열 -> String
		String str2 = new String(charArr);
		System.out.println(str2);
		
		// 특정 문자를 기준으로 나누기
		str = "aa/bbb/cc/ddd";
		String[] strArr = str.split("/"); // "/"를 기준으로 문자열을 배열로 나눠서 반환
		System.out.println(strArr.length);
		System.out.println(strArr[2]);
		
		// 특정 문자의 위치(index) 찾기
		str = "byebyebye";
		System.out.println(str.indexOf("e")); // 앞에서부터 e를 찾음. 2
		System.out.println(str.lastIndexOf("b")); // 뒤에서부터 b를 찾음. 6
		
		System.out.println();
		// 특정 문자의 모든 위치 찾기
		int i = 0;
		while (str.indexOf("e", i) != -1) {
			System.out.println(str.indexOf("e", i));
			i = str.indexOf("e", i) + 1;
		}
		
	}

}
