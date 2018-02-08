package chap07.ex07.throwsEx;

public class Sub {

	public void method1() throws Exception {
		method2();
	}

	private void method2() throws Exception {
		Integer.parseInt("abcd"); // NumberFormatException
	}

}
