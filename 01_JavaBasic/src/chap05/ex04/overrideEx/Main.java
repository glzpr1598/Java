package chap05.ex04.overrideEx;

public class Main {

	public static void main(String[] args) {
		
		MyCar car = new MyCar();
		
		car.start();
		car.run();
		
		car.turbo = true;
		car.run();
		
		car.turbo = false;
		car.run();
		
		car.stop();

	}

}
