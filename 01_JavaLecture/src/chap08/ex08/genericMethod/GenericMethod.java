package chap08.ex08.genericMethod;

public class GenericMethod {
	
	// generic 메서드
	// 1. 매개변수 타입에 사용
	public <T> void method1(T t) {
		System.out.println("입력 값 : " + t);
	}
	
	// 2. 매개변수, 반환 타입에 모두 사용
		public <T> T method2(T t) {
			return t;
		}
	
	// 활용
	public <T> Box<T> method3(T t) {
		Box<T> box = new Box<T>();
		box.setT(t);
		return box;
	}

}
