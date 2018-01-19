package chap06.ex07.inherit;

public class ChildImp implements Child {

	@Override
	public void keyDown(int btn) {
		System.out.println(btn + " down.");
	}

	@Override
	public void keyUp(int btn) {
		System.out.println(btn + " up.");
	}

	@Override
	public void click(int btn) {
		System.out.println(btn + " click.");
	}

	@Override
	public void dblClick(int btn) {
		System.out.println(btn + " double click.");
	}

	@Override
	public void textField(String str) {
		System.out.println("Text : " + str);
	}

	@Override
	public void selectOne() {
		System.out.println("Select one.");
	}

	@Override
	public void checkOne() {
		System.out.println("Check one.");
	}

}
