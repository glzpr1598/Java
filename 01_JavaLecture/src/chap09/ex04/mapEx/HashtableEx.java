package chap09.ex04.mapEx;

import java.util.Hashtable;
import java.util.Map;

public class HashtableEx {
	// HashTable은 HashMap과 사용법이 똑같으나, 동시에 여러 thread가 접근할 수 없다.
	public static void main(String[] args) {

		Map<String, Integer> map = new Hashtable<String, Integer>();
		
		// 데이터 추가
		map.put("Kim",	100);
		map.put("Lee", 80);
		map.put("Park", 70);
		map.put("Yu", 90);
		map.put("Jeong", 100);

	}

}
