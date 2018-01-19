package chap06.ex02.abstractEx;

public class Concrete extends Abs {

	// 추상 메서드는 Abs를 상속함과 동시에 자동으로 생성된다.
	// 반드시 override 해야한다.
	@Override
	public void must1() {
		System.out.println("Override must1");
	}

	@Override
	public void must2() {
		System.out.println("Override must2");
	}

}
