package chap06.ex02.abstractEx;

public class Main {

	public static void main(String[] args) {
		
		// 추상 메서드는 객체화가 불가능
		//Abs abs = new Abs();
		
		Abs abs = new Concrete();
		
		// 일반 메서드
		abs.parent();
		// override한 추상메서드
		abs.must1();
		abs.must2();

	}

}
