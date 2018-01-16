package chap04.ex05.memberCall;

public class Car {
	
	int gear = 0;
	boolean on = false;
	
	public Car() {
		
	}
	
	void start() {
		if (on) {
			System.out.println("시동이 이미 걸려있습니다.");
		} else {
			on = true;
			System.out.println("시동이 걸렸습니다.");
		}
	}
	
	void change(int gear) {
		this.gear = gear;
		System.out.println("현재 기어 : " + this.gear + "단");
	}

}
