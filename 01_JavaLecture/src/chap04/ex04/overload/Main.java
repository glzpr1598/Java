package chap04.ex04.overload;

// overload는 같은 이름으로 여러개의 메소드나 생성자를 만들게 해준다.
public class Main {

	public static void main(String[] args) {

		NoteBook nb1 = new NoteBook();
		
		// String model, int price, String color
		NoteBook nb2 = new NoteBook("gram", 120, "white");
		
		// String model, String color
		NoteBook nb3 = new NoteBook("sense", "silver");
		
		// String model, int price
		NoteBook nb4 = new NoteBook("sense", 100);
		
		// String color, int price
		NoteBook nb5 = new NoteBook("color5", 50); // color5가 모델이름으로 들어감.

	}

}
