package chap06.ex06.anony;

public class Main {

	public static void main(String[] args) {

		// 인터페이스를 구현하는 클래스를 따로 만들지 않고 바로 구현하여 사용하고 싶을 때
		Inter inter = new Inter() {
		
			@Override
			public void test1() {
				System.out.println("익명 객체 test1");
			}
			
			@Override
			public void test2() {
				System.out.println("익명 객체 test2");
			}
		
		};
	}

}
