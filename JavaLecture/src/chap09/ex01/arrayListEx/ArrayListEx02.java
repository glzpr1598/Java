package chap09.ex01.arrayListEx;

import java.util.ArrayList;

public class ArrayListEx02 {
	// 데이터 수정, 검색, 초기화
	public static void main(String[] args) {
		
		ArrayList<Integer> scores = new ArrayList<Integer>();
		scores.add(70);
		scores.add(90);
		scores.add(60);
		scores.add(100);
		scores.add(90);
		
		// 데이터 수정(set)
		scores.set(2, 80); // 수정 전 데이터 반환
		
		// 데이터 검색(contains, indexOf)
		System.out.println("50이 있습니까? " + scores.contains(50)); // 데이터 포함 여부 반환
		System.out.println("90이 몇 번 index에 있습니까? " + scores.indexOf(90)); // 데이터의 위치 반환(첫번째만)
		
		// 데이터 초기화(clear, isEmpty)
		System.out.println(scores.isEmpty()); // 데이터가 존재 여부
		scores.clear(); // 데이터 초기화
		System.out.println(scores.isEmpty());

	}

}
