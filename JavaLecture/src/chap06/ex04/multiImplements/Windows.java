package chap06.ex04.multiImplements;

public class Windows implements KeyEvent, MouseEvent {

	// KeyEvent의 추상 메서드
	@Override
	public void keyDown(int btn) {
		System.out.println(btn + " down.");
	}

	@Override
	public void keyUp(int btn) {
		System.out.println(btn + " up.");
	}
	
	// MouseEvent의 추상 메서드
	@Override
	public void click(int btn) {
		System.out.println(btn + " click.");
	}

	@Override
	public void dblClick(int btn) {
		System.out.println(btn + " double click.");
	}

}
