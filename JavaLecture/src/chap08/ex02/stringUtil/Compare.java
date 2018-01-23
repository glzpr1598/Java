package chap08.ex02.stringUtil;

public class Compare {

	public static void main(String[] args) {
		// String은 문자열이 추가될 때마다 추가 객체를 생성한다.
		String str = "문자열은 ";
		str += "추가할 때마다 ";
		str += "객체가 추가된다.";
		System.out.println(str);
		
		// StringBuffer와 Builder는 문자열 추가시 크기만 늘어난다.
		StringBuffer buffer = new StringBuffer("문자열을 ");
		buffer.append("추가할 때마다 ");
		buffer.append("객체 크기만 증가한다.");
		System.out.println(buffer);

	}

}
