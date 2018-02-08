package chap04.ex04.overload;

public class NoteBook {

	String model, color;
	int price;
	
	public NoteBook() {
		
	}
	
	public NoteBook(String model, int price, String color) {
		model = model;
		price = price;
		color = color;
		// 클래스 변수에 값이 들어가지 않음!
	}
	
	// 방법 1. 변수 이름을 다르게.
	public NoteBook(String m, String c) {
		model = m;
		color = c;
	}
	
	// 방법 2. this 사용.(추천)
	// this는 현재 클래스를 가리킴.
	public NoteBook(String model, int price) {
		this.model = model;
		this.price = price;
	}
	
	// 매개변수 타입이 같으므로 안됨.
//	public NoteBook(String color, int price) {
//		
//	}

}
