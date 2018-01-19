package chap06.ex03.interfaceEx;

public class Main {

	public static void main(String[] args) {

		Windows windows = new Windows();
		windows.click(1);
		Linux linux = new Linux();
		linux.dblClick(1);
		Mac mac = new Mac();
		mac.click(2);
		
		System.out.println();
		
		// 다형성은 상속뿐만 아니라, 구현 관계에서도 사용 가능하다.
		MouseEvent me;
		me = new Windows();
		me.click(1);
		me = new Linux();
		me.dblClick(1);
		me = new Mac();
		me.click(2);
		
		System.out.println();
		
		// JDK 1.8부터 사용 가능한 기능들
		me.wheel(1); // default method
		MouseEvent.setDpi(1000); // static method

	}

}
