package chap05.ex05.poly;

public class Child1 extends Parent {
	
	@Override
	public void useRoom() {
		System.out.println("첫째가 방을 사용한다.");
	}
	
}

// public 클래스는 파일명과 같은 클래스만 사용할 수 있다.
class Child2 extends Parent {
	
	@Override
	public void useRoom() {
		System.out.println("둘째가 방을 사용한다.");
	}

}

class Child3 extends Parent {
	
	@Override
	public void useRoom() {
		System.out.println("셋째가 방을 사용한다.");
	}

}

class Child4 extends Parent {
	
	@Override
	public void useRoom() {
		System.out.println("넷째가 방을 사용한다.");
	}

}
