package chap08.ex04.generic;

public class Box<T> { // 특정 타입을 받을 예정이다.
	
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
