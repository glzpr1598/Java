package chap06.ex08.vingsu;

public class CookieVingsu implements Vingsu {

	@Override
	public void iceFlake() {
		System.out.println("얼음");	
	}

	@Override
	public void milk() {
		System.out.println("우유");
	}

	@Override
	public void redBean() {
		System.out.println("팥");
	}

	@Override
	public void jelly() {
		System.out.println("젤리");
	}

	@Override
	public void etc() {
		System.out.println("쿠키");
	}

}
