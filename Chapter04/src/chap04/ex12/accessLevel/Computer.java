package chap04.ex12.accessLevel;

public class Computer {

	private boolean power; // 읽기, 쓰기
	private int panSpeed; // 읽기, 쓰기
	private int temp; // 읽기
	// panSpeed에 따라 temp가 바뀜.

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
		// 파워가 true일 경우 panSpeed = 50, temp = 60으로 설정
		if (this.power) {
			this.panSpeed = 50;
			this.temp = 60;
		} else {
			this.panSpeed = 0;
			this.temp = 0;
		}
	}

	public int getPanSpeed() {
		return panSpeed;
	}

	public void setPanSpeed(int panSpeed) {
		// panSpeed에 따라 temp 변화
		if (this.power) {
			this.panSpeed = panSpeed;
			this.temp = 110 - this.panSpeed;
		} else {
			System.out.println("전원이 꺼져있습니다.");
		}
	}

	// getter
	public int getTemp() {
		return temp;
	}

}
