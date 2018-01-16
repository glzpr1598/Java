package chap04.ex03.constr;

public class Robot {
	
	public String name, goal;
	
	public Robot(String n, String g) {
		System.out.println("생성자는 클래스가 객체화될 때 가장 먼저 실행됩니다.");
		name = n;
		goal = g;
	}

}
