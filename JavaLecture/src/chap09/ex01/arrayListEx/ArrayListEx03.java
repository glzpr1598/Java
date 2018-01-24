package chap09.ex01.arrayListEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx03 {
	
	public static void main(String[] args) {
		
		// array -> List 변환
		String[] arr = {"ArrayList", "Vector", "LinkedList"};
		List<String> list = Arrays.asList(arr); // List 형으로 반환

		// List 형이기 때문에 조회는 할 수 있으나 변경은 불가능
		System.out.println(list.size());
		System.out.println(list.get(0));
		
		// ArrayList로 변환
		ArrayList<String> arrList = new ArrayList<String>();
		
		// List의 데이터 한번에 넣기
		arrList.addAll(list);
		System.out.println("리스트 크기 : " + arrList.size());
		arrList.add("Collection"); // ArraryList로 변환했기 때문에 데이터 추가 가능
		System.out.println("리스트 크기 : " + arrList.size());
		
	}

}
