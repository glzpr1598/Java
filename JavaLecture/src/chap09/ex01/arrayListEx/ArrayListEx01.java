package chap09.ex01.arrayListEx;

import java.util.ArrayList;

public class ArrayListEx01 {
	// 데이터 추가, 가져오기, 크기, 삭제
	public static void main(String[] args) {

		// ArrayList는 배열과 비슷하지만 크기에 제한이 없다.
		// 선언시 생성자를 통해 크기 지정을 할 수도 있다.
		// Vector는 ArrayList와 거의 동일하지만 특정 thread가 접근 시 다른 thread가 접근하지 못한다.
		ArrayList<String> list = new ArrayList<String>();

		// 데이터 추가(add)
		list.add("Kim"); // 0
		list.add("Lee"); // 1
		list.add("Park"); // 2
		list.add(1, "Yu"); // 위치를 지정하여 가운데 삽입할 수도 있다.

		// 데이터 가져오기(get)
		System.out.println("데이터 출력");
		System.out.println(list.get(0)); // Kim
		System.out.println(list.get(1)); // Yu
		System.out.println(list.get(2)); // Lee
		System.out.println(list.get(3)); // Park

		// 리스트 크기(size)
		System.out.println("리스트 크기 : " + list.size());

		// for문을 활용하여 모든 데이터 출력
		System.out.println("for문을 활용하여 모든 데이터 출력");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 데이터 삭제(remove)
		System.out.println("인덱스로 삭제 : " + list.remove(2)); // 인덱스로 삭제하면 삭제한 값 반환
		System.out.println("값으로 삭제 : " + list.remove("Park")); // 값으로 삭제하면 성공여부 반환, 첫번째로 일치하는 값 하나만 삭제
		
		// 향상된 for문을 활용하여 모든 데이터 출력
		System.out.println("향상된 for문을 활용하여 모든 데이터 출력");
		for (String temp : list) {
			System.out.println(temp);
		}

	}

}
