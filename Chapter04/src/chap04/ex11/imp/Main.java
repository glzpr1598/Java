package chap04.ex11.imp;

import chap04.ex06.methodOverload.Calculator;

public class Main {

	public static void main(String[] args) {

		// 다른 패키지의 클래스를 호출 -> import 자동 삽입
		Calculator cal = new Calculator();
		// 다른 패키지일 경우 public 변수와 메서드만 호출 가능
		System.out.println(cal.add(2, 3));
		
	}

}
