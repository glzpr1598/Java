package chap07.ex02.nestedInterface;

// 중첩 인터페이스
public class Main {

	public static void main(String[] args) {

		Element element = new Element();
		
		element.regist(new OnClickListener());
		element.trigger();
		
		element.regist(new OnKeyListener());
		element.trigger();

	}

}
