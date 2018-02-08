package chap06.ex01.inherit;

public abstract class Mammal {
	
	public String name;
	
	public Mammal(String name) {
		this.name = name;
	}
	
	public void birth() {
		System.out.println(name + "이 자식을 낳는다.");
	}
	
	public void eat() {
		System.out.println(name + "이 젖을 먹인다.");
	}

}
