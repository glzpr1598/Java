package chap05.ex07.cast;

public class Dog extends Mammal {
	
	@Override
	public void birth() {
		System.out.println("강아지를 낳는다.");
	}
	
	public void bark() {
		System.out.println("멍멍하고 운다.");
	}
	
}
