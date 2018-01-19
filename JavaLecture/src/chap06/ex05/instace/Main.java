package chap06.ex05.instace;

public class Main {

	public static void main(String[] args) {
		// 다형성을 사용하지 않은 경우
		CommonImp imp = new CommonImp();
		imp.test1();
		
		// 다형성을 사용한 경우
		Common com = new CommonImp();
		com.test2();

	}

}
