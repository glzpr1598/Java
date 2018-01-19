package chap06.ex07.inherit;

public class Main {

	public static void main(String[] args) {
		
		ChildImp ci = new ChildImp();
		
		ci.click(1);
		ci.dblClick(2);
		ci.keyDown(3);
		ci.keyUp(3);
		ci.textField("Test");
		ci.selectOne();
		ci.checkOne();
		
	}

}
