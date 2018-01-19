package chap06.ex02.abstractEx;

public abstract class Abs {

	// 추상 메서드(반드시 오버라이드 해야하는 메서드)
	public abstract void must1();
	public abstract void must2();
	
	// 일반 메서드(그냥 사용하거나 오버라이드 할 수 있는 메서드)
	public void parent() {
		System.out.println("일반 메서드");
	}

}
