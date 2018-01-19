package chap06.ex01.inherit;

public class Person extends Mammal {

	public Person(String name) {
		super(name);
	}
	
	public void useTool() {
		System.out.println(name + "이 도구를 사용한다.");
	}
	
	public void social() {
		System.out.println(name + "이 사회생활을 한다.");
	}
	
	public void talk() {
		System.out.println(name + "이 이야기를 한다.");
	}

}
