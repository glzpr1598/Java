package chap07.ex03.nestedInterface2;

public class Main {

	public static void main(String[] args) {

		Element element = new Element();
		
		element.regist(new OnClickListener());
		element.trigger();
		
		element.regist(new OnKeyListener());
		element.trigger();

	}

}
