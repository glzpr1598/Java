package chap06.ex01.inherit;

public class Main {

	public static void main(String[] args) {
		// 1. 추상화 클래스는 상속해서 사용해야 한다. 
		// 2. 추상화 클래스는 객체화를 할 수 없다.

		// Mammal mammal = new Mammal("포유류"); // 추상화 클래스는 객체화 불가능
		Person person = new Person("Kim");
		// 상위 클래스의 메서드
		person.birth();
		person.eat();
		// 하위 클래스의 메서드
		person.useTool();
		person.social();
		person.talk();

	}

}
