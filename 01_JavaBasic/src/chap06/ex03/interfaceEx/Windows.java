package chap06.ex03.interfaceEx;

public class Windows implements MouseEvent {

	@Override
	public void click(int btn) {
		System.out.println("Windows 마우스 " + btn + "번 버튼 클릭");
	}

	@Override
	public void dblClick(int btn) {
		System.out.println("Windows 마우스 " + btn + "번 버튼 더블클릭");
	}

	@Override
	public double[] move() {
		return null;
	}

}
