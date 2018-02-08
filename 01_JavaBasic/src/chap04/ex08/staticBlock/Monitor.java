package chap04.ex08.staticBlock;

public class Monitor {
	
	static String company = "Samsung";
	static String model = "Wide Cube Monitor";
	static int price;
	
	// static 블록은 클래스가 호출되는 순간에 실행된다.
	static {
		System.out.println("static 블록 호출!");
		price = 250000;
	}

}
