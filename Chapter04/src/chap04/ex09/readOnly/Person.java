package chap04.ex09.readOnly;

public class Person {
	
	// final 변수는 값을 한 번 할당하면 변경할 수 없다.
	final String nation;
	final String name;
	static final String ssn;	
	
	// final 변수는 생성할 때(생성자) 값을 할당해주어야 한다. (위에서 변수 선언할 때 해도 됨.)
	public Person(String nation, String name) {
		this.nation = nation;
		this.name = name;
	}
	
	// static final 변수는 static 블록을 통해 값을 할당해주어야 한다. (위에서 변수 선언할 때 해도 됨.)
	static {
		ssn = "930827-1234567";
	}

}
