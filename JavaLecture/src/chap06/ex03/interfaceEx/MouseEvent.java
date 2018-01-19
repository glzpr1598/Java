package chap06.ex03.interfaceEx;

public interface MouseEvent {

	// 인터페이스는 추상화 메서드만 정의할 수 있다.
	// 따라서 abstract 키워드를 생략해도 된다.
	public void click(int btn);
	public void dblClick(int btn);
	public double[] move();

	// ※ 아래는 참고 ※
	// JDK 1.8 부터 default 메서드 제공 -> 일반 메서드처럼 사용 가능 -> abstract 클래스와 차이가 적어짐
	public default void wheel(int i) {
		if (i == 1) {
			System.out.println("윗방향 스크롤");
		} else {
			System.out.println("아랫방향 스크롤");
		}
	}

	// JDK 1.8 부터 static 메서드 제공 -> 클래스명으로 접근 가능
	public static void setDpi(int dpi) {
		System.out.println("감도 조절 : " + dpi);
	}

}
