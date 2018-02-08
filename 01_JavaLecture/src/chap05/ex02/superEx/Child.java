package chap05.ex02.superEx;

public class Child extends Parent {
	
	public String field;
	
	public Child(String attr1, int attr2, String field) {
		super(attr1, attr2); // 자식 생성자가 호출되면 가장 먼저 부모 생성자를 먼저 호출
		this.field = field;
	}

}
