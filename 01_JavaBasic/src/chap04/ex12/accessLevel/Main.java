package chap04.ex12.accessLevel;

public class Main {

	public static void main(String[] args) {
		
		Computer com = new Computer();
		
		// 컴퓨터 전원을 켠다.
		com.setPower(true);
		System.out.println("전원이 켜졌습니다.");
		
		// 팬속도를 확인한다.
		System.out.println("팬 속도 : " + com.getPanSpeed());
		
		// 온도를 확인한다.
		System.out.println("온도 : " + com.getTemp());
		
		// 팬속도를 조절한다.
		com.setPanSpeed(80);
		System.out.println("팬 속도를 " + com.getPanSpeed() + "(으)로 조절하였습니다.");
		
		// 온도를 확인한다.
		System.out.println("온도 : " + com.getTemp());

	}

}
