package chap05.ex04.overrideEx;

public class MyCar extends ParentCar {
	
	public boolean turbo = false;

	// turbo 옵션에 따라 50km(상위 클래스), 200km(하위 클래스) 선택 가능하게
	@Override
	public void run() {
		if (turbo) {
			System.out.println("시속 200km로 달린다.");
		} else {
			super.run(); // 상위 클래스의 run() 메서드
		}
		
	}

}
