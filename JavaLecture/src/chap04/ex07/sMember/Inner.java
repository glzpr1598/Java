package chap04.ex07.sMember;

public class Inner {

	public static void main(String[] args) {
		
		// main 메소드에서 static이 아닌 message 메소드를 호출하려면
		
		// 방법 1. 객체화
		Inner inner = new Inner();
		inner.message("Hello");
		
		// 방법 2. 메소드의 영역을 같게 함.(둘 다 static으로 or 둘 다 non-static으로)
		// main 메소드는 static을 삭제할 수 없음. 

	}
	
	void message(String msg) {
		System.out.println("당신이 입력한 메시지 : " + msg);
	}

}
