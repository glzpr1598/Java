package chap08.ex02.stringUtil;

public class StringUtil {

	public static void main(String[] args) {

		String str;
		
		// 문자열 비교
		str = "test";
		System.out.println(str.equals("test")); // boolean 반환
		System.out.println(str.compareTo("apple")); // 같으면 0, 사전순서에서 앞이면 음수, 뒤면 양수 반환(아스키코드로 str - apple)
		
		// 앞뒤 공백 제거
		str = " abc ";
		System.out.println(str);
		System.out.println(str.trim()); // String 반환
		
		// 특정 문자 포함 여부
		str = "test";
		System.out.println(str.contains("st")); // boolean 반환
		
		// 특정 문자열로 시작, 종료 여부
		str = "[img]test.jpg";
		System.out.println(str.startsWith("[img]")); // boolean 반환
		System.out.println(str.endsWith(".png")); // boolean 반환
		
		// 문자열 치환
		System.out.println(str.replace("jpg", "png")); // String 반환

	}

}
