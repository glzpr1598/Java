package chap05.ex04.overrideEx;

public class ParentCar {
	
	public void start() {
		System.out.println("시동을 건다.");
	}
	
	public void run() {
		System.out.println("시속 50km로 달린다.");
	}
	
	public void stop() {
		System.out.println("멈춘다.");
	}
	
	// final 키워드가 있으면 override 할 수 없다.
	public final void test() {
		System.out.println("자체 점검");
	}

}
