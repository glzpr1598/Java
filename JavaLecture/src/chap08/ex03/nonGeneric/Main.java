package chap08.ex03.nonGeneric;

public class Main {

	public static void main(String[] args) {

		Box box = new Box(); // Box 안에는 뭐가 들어갈 지 몰라서 object로 선언했다.
		box.setValue(1234);
		int value = (int) box.getValue(); // 그러다보니 값을 넣으려면 casting을 해야한다.

	}

}
