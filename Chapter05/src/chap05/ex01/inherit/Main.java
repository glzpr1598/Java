package chap05.ex01.inherit;

public class Main {

	public static void main(String[] args) {
		
		// Person은 Mamal을 상속받음.
		Person person = new Person();
		
		// Mamal의 메서드
		person.birth();
		person.eat();
		// Person의 메서드
		person.useTool();
		person.social();
		person.talk();

	}

}
