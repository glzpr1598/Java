package chap09.ex04.mapEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		
		// HashMap 객체화
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		// 데이터 추가(put)
		map.put("Kim", 26);
		map.put("Lee", 23);
		map.put("Park", 23); // 값 중복은 허용
		map.put("Kim", 25); // 키 중복은 허용되지 않음. 덮어씀.
		map.put("Jeong", 25);
		
		// 데이터 꺼내기(get)
		System.out.println("Kim에 해당하는 데이터 : " + map.get("Kim"));
		
		// 데이터 삭제(remove)
		map.remove("Park");
		
		// 데이터 포함 여부(containKey, containValue)
		System.out.println("Park라는 Key 포함 여부 : " + map.containsKey("Park"));
		System.out.println("25라는 Value 포함 여부 : " + map.containsValue(25));
		
		// 크기 확인(size)
		System.out.println("map의 크기 : " + map.size());

		// 모든 데이터 가져오기
		// 방법 1. key만 Set으로 가져와서 iterator로 쪼갬.
		System.out.println("모든 데이터 출력");
		Set<String> keySet = map.keySet();
		Iterator<String> ketIter = keySet.iterator();
		while (ketIter.hasNext()) {
			String key = ketIter.next();
			System.out.println(key + " : " + map.get(key));
		}
		
		// 방법 2. Entry(K-V)를 Set으로 가져와서 iterator로 쪼갬.
		System.out.println("Entry를 이용해 모든 데이터 출력");
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> entryIter = entrySet.iterator();
		while (entryIter.hasNext()) {
			Entry<String, Integer> entry = entryIter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 응용 : 특정 값을 가지고 있는 모든 키 출력
		System.out.println("Value가 25인 모든 Key 출력");
		Set<Entry<String, Integer>> entrySet2 = map.entrySet();
		Iterator<Entry<String, Integer>> entryIter2 = entrySet2.iterator();
		while (entryIter2.hasNext()) {
			Entry<String, Integer> entry2 = entryIter2.next();
			if (entry2.getValue() == 25)
				System.out.println("Value가 25인 Key : " + entry2.getKey());
		}
		
		// 데이터 초기화(clear, isEmpty)
		if (!map.isEmpty()) {
			System.out.println("map 초기화");
			map.clear();
		}
		
		// HashTable은 HashMap과 사용법이 똑같으나, 동시에 여러 thread가 접근할 수 없다.
		
	}

}
