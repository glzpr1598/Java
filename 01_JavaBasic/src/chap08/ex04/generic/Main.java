package chap08.ex04.generic;

public class Main {

	public static void main(String[] args) {

		Box<Integer> box = new Box<Integer>(); // 객체화 할 때 타입을 정의
		box.setValue(1234);
		int value = box.getValue(); // 캐스팅을 할 필요가 없다.

	}

}
