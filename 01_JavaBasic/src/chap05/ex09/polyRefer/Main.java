package chap05.ex09.polyRefer;

public class Main {

	public static void main(String[] args) {

		// 레이서를 부른다.
		Racer racer = new Racer();
		
		// 차를 가져온다.
		Car car = new Maserati();
		
		// 레이서에게 차를 운전시킨다.
		racer.drive(car);
		racer.drive(new Ferrari());
		racer.drive(new Mclaren());
		
	}

}
