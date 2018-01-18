package chap05.ex05.poly;

// 다형성
public class Main {

	public static void main(String[] args) {

		// 4형제가 각각 useRoom()을 사용
		Child1 child1 = new Child1();
		Child2 child2 = new Child2();
		Child3 child3 = new Child3();
		Child4 child4 = new Child4();
		
		child1.useRoom();
		child2.useRoom();
		child3.useRoom();
		child4.useRoom();
		
		// 위와 같은 방법은 변수가 많아지면 힙 영역의 낭비가 심해진다.
		// 다형성을 활용하면 메모리를 효율적으로 사용할 수 있다.
		System.out.println();
		System.out.println("- 다형성 활용 -");
		
		Parent parent;
		parent = new Child1();
		parent.useRoom();
		
		parent = new Child2();
		parent.useRoom();
		
		parent = new Child3();
		parent.useRoom();
		
		parent = new Child4();
		parent.useRoom();
		

	}

}
