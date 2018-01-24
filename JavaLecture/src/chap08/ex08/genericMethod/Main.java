package chap08.ex08.genericMethod;

public class Main {

	public static void main(String[] args) {

		GenericMethod gm = new GenericMethod();
		
		// 인자 타입에 상관없이 실행됨.
		gm.method1(10);
		gm.method1("Kim");
		gm.method1(true);
		
		System.out.println();
		
		// 인자 타입에 따라 반환 타입이 정해짐
		int intVal = gm.method2(20);
		char charVal = gm.method2('A');
		boolean boolVal = gm.method2(false);
		
		System.out.println(intVal);
		System.out.println(charVal);
		System.out.println(boolVal);
		
		System.out.println();
		
		// 클래스 반환 이용
		Box<Integer> box1 = gm.method3(100);
		System.out.println(box1.getT());
		
		Box<String> box2 = gm.method3("Kim");
		System.out.println(box2.getT());
		
	}

}
